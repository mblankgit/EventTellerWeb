package action;

import index.WordIndex;
import index.model.WebWord;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.alibaba.fastjson.JSON;

import model.JsonWordGraph;
import model.JsonWordLink;
import model.JsonWordNode;

public class GetWordAction {
	
	private String name;
	private String nature;
	private String timeline;
	private int startDay;
	private int endDay;
	private String relatedWords;
	private String status;
	private String personGraph;
	
	
	private List<String> relatedPersons;
	private List<String> relatedPositions;
	private List<String> relatedVerbs;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getTimeline() {
		return timeline;
	}
	public void setTimeline(String timeline) {
		this.timeline = timeline;
	}
	public int getStartDay() {
		return startDay;
	}
	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}
	public int getEndDay() {
		return endDay;
	}
	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}
	public String getRelatedWords() {
		return relatedWords;
	}
	public void setRelatedWords(String relatedWords) {
		this.relatedWords = relatedWords;
	}
	
	public List<String> getRelatedPersons() {
		return relatedPersons;
	}
	public void setRelatedPersons(List<String> relatedPersons) {
		this.relatedPersons = relatedPersons;
	}
	public List<String> getRelatedPositions() {
		return relatedPositions;
	}
	public void setRelatedPositions(List<String> relatedPositions) {
		this.relatedPositions = relatedPositions;
	}
	public List<String> getRelatedVerbs() {
		return relatedVerbs;
	}
	public void setRelatedVerbs(List<String> relatedVerbs) {
		this.relatedVerbs = relatedVerbs;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getPersonGraph() {
		return personGraph;
	}
	public void setPersonGraph(String personGraph) {
		this.personGraph = personGraph;
	}






	class wordNumber implements Comparable<wordNumber>{
        public String name;
        public int count;
        public int compareTo(wordNumber other){
            if(other.count > this.count){
                return 1;
            }else{
                return -1;
            }
        }
    }
	
	
	public String getWordTime() throws UnsupportedEncodingException{
		 WordIndex wi = new WordIndex();
		 WebWord word = wi.queryIds(name);
		 if(word == null){
			 status = "404";
		 }else{
			 status = "200";
			 timeline = word.getWordTimeNumber();
			 processPersonGraph(name,word.getPersonGraph());
		 }
		return "success";
	}
	
	private void processPersonGraph(String word,String scr){
		int tid = 0,tgroup = 1;
		HashMap<String,Integer> idIndex = new HashMap<String,Integer>();
		HashMap<String,Integer> groups = new HashMap<String,Integer>();
		HashMap<String,Double> sizes = new HashMap<String,Double>();
		List<String> ids = new ArrayList<String>();
		JsonWordGraph jwg = new JsonWordGraph();
		String[] its = scr.split("\t");
		for(String it : its){
			String[] subs = it.split(",");
			double tval = Double.parseDouble(subs[2]) * 10;
			if(tval < 4){
				continue;
			}
			JsonWordLink jwl = new JsonWordLink();
			if(subs.length != 3){
				continue;
			}
			Integer indexa = null;
			Integer indexb = null;
			if(subs[0].equals(word)){
				sizes.put(subs[1], 18.0);
				sizes.put(subs[0], 30.0);
				if(!groups.containsKey(subs[1])){
					groups.put(subs[1], tgroup++);
				}
			}else{
				sizes.put(subs[1],10.0);
				if(groups.containsKey(subs[0])){
					groups.put(subs[1], groups.get(subs[0]));
				}else{
					groups.put(subs[0], tgroup++);
					groups.put(subs[1], groups.get(subs[0]));
				}				
			}
			if(idIndex.containsKey(subs[0])){
				indexa = idIndex.get(subs[0]);
			}else{
				ids.add(subs[0]);
				indexa = tid++;
				idIndex.put(subs[0], indexa);
			}
			if(idIndex.containsKey(subs[1])){
				indexb = idIndex.get(subs[1]);
			}else{
				ids.add(subs[1]);
				indexb = tid++;
				idIndex.put(subs[1], indexb);
			}
			jwl.target = indexa;
			jwl.source = indexb;
			jwl.value = tval;
			jwg.links.add(jwl);
		}
		for(String id : ids){
			JsonWordNode jwn = new JsonWordNode();
			jwn.name = id;
			jwn.group = groups.get(id);
			jwn.size = sizes.get(id);
			jwg.nodes.add(jwn);
		}
		personGraph = JSON.toJSONString(jwg);
	}
	
	private void processRelatedWords(String scr){
		relatedPersons = new ArrayList<String>();
		relatedPositions= new ArrayList<String>();
		relatedVerbs = new ArrayList<String>();
		//add to list
		//get days
		String[] days = scr.split("\t");
//		StringBuffer res = new StringBuffer();
        HashMap<String,HashMap<String,Integer>> numbers = new HashMap<String, HashMap<String, Integer>>();
        HashMap<String,HashSet<Integer>> ids = new HashMap<String, HashSet<Integer>>();
		for(String day : days){
			String[] types = day.split(" ");
			int numDay = Integer.parseInt(types[0]);
			if(numDay < startDay || numDay > endDay){
				continue;
			}
			for(int i = 1; i < types.length; ++i){
				String[] words = types[i].split(",");
                if(!words[0].equals("nr") && !words[0].equals("ns") && !words[0].equals("v")){
                    continue;
                }
				for(int j = 1; j < words.length; ++j){
					String[] names = words[j].split(";");
					int total = 0;
					for(int k = 1; k<names.length; ++k){
						String[] tids = names[k].split("[|]");
						int tnum = Integer.parseInt(tids[1]);
						int tid = Integer.parseInt(tids[0]);
						if(ids.containsKey(names[0])){
							if(ids.get(names[0]).size() > 15){
								continue;
							}
							ids.get(names[0]).add(tid);
						}else{
							HashSet<Integer> tmps = new HashSet<Integer>();
							tmps.add(tid);
							ids.put(names[0], tmps);
						}
						total+=tnum;
					}
					if(numbers.containsKey(words[0])){
                        if(numbers.get(words[0]).containsKey(names[0])){
                            numbers.get(words[0]).put(names[0],numbers.get(words[0]).get(names[0]) + total);
                        }else{
                            numbers.get(words[0]).put(names[0],total);
                        }
                    }else{
                        HashMap<String,Integer> tnum = new HashMap<String, Integer>();
                        tnum.put(names[0],total);
                        numbers.put(words[0],tnum);
                    }					
				}				
			}
		}
		 //sort and get topN word add result to res
        for(String type : numbers.keySet()){
            List<wordNumber> words = new ArrayList<wordNumber>();
            for(String word : numbers.get(type).keySet()){
                wordNumber wn = new wordNumber();
                wn.name = word;
                wn.count = numbers.get(type).get(word);
                words.add(wn);
            }
            //sort words
            Collections.sort(words);
            //add to res..
            for(int i = 0 ; i < 10; ++i){
            	StringBuffer tres = new StringBuffer();
                if(i == words.size()){
                    break;
                }
                tres.append(words.get(i).name  + "\t" + words.get(i).count + ",");
                for(Integer id : ids.get(words.get(i).name)){
                    tres.append(id + ";");
                }
                if(type.equals("nr")){
                	relatedPersons.add(tres.toString()); 
                }else if(type.endsWith("ns")){
                	relatedPositions.add(tres.toString());
                }else{
                	relatedVerbs.add(tres.toString()); 
                }
            }

        }
		System.out.println(relatedVerbs.size() + "\t" + relatedPositions.size() + "\t" + relatedPersons.size());
	}
	
	
	public String getRelatedWord(){
		 WordIndex wi = new WordIndex();
		 WebWord word = wi.queryIds(name);
		 if(word == null){
			 status = "404";
		 }else{
			 status = "200";
			 processRelatedWords(word.getRelatedWords());
		 }
		 return "success";
	}
	
	

}
