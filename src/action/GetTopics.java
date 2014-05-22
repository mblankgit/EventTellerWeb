package action;

import index.TopicIndex;
import index.model.WebTopic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.JsonWordGraph;
import model.JsonWordLink;
import model.JsonWordNode;

import com.alibaba.fastjson.JSON;

import db.Topic;

public class GetTopics {
	
	private String ids;
	private List<Topic> tps;
	private String eventsGraph;
	private String eventRelations;
	
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public List<Topic> getTps() {
		return tps;
	}
	public void setTps(List<Topic> tps) {
		this.tps = tps;
	}
	
	
	public String getEventsGraph() {
		return eventsGraph;
	}
	public void setEventsGraph(String eventsGraph) {
		this.eventsGraph = eventsGraph;
	}
	
	public String getEventRelations() {
		return eventRelations;
	}
	public void setEventRelations(String eventRelations) {
		this.eventRelations = eventRelations;
	}
	
	
	private String processKeyWord(String key,int N){
		String[] its = key.split(",");
		StringBuffer res = new StringBuffer();
		int count = 0;
		for(String it : its){
			String[] subs = it.split(":");
			if(subs.length == 2){
				res.append(subs[0] + " ");
				count++;
				if(count > N){
					break;
				}
			}
		}
		return res.toString();
	}
	
	public String getTopicsByIds(){
		if(ids == null || ids.length() == 0){
			return "success";
		}
		tps = new ArrayList<Topic>();
		TopicIndex ti = new TopicIndex();
		String[] id = ids.split(" ");
		for(String tid : id){
			WebTopic wtp = ti.queryIds(tid);
			if(wtp != null){
				wtp.tp.setKeyWords(processKeyWord(wtp.tp.getKeyWords(),10));
				tps.add(wtp.tp);
			}
		}
		System.out.println(ids + "\t" + tps.size() );
		processPersonGraph(eventRelations);
		return "success";
	}
	
	private void processPersonGraph(String scr){
		int tid = 0,tgroup = 1;
		double baseSize = 5;
		HashMap<String,Integer> idIndex = new HashMap<String,Integer>();
		HashMap<String,Integer> groups = new HashMap<String,Integer>();
		HashMap<String,Double> sizes = new HashMap<String,Double>();
		List<String> ids = new ArrayList<String>();
		JsonWordGraph jwg = new JsonWordGraph();
		String[] its = scr.split("@##@");
		for(String it : its){
			System.out.println(it);
			String[] subs = it.split("[|]");
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
			if(sizes.containsKey(subs[1])){
				sizes.put(subs[1], 2 + sizes.get(subs[1]));
			}else{
				sizes.put(subs[1], baseSize);
			}
			if(!sizes.containsKey(subs[0])){
				sizes.put(subs[0], baseSize);
			}
			if(!groups.containsKey(subs[1])){
				groups.put(subs[1], tgroup++);
			}
			if(groups.containsKey(subs[0])){
				groups.put(subs[1], groups.get(subs[0]));
			}else{
				groups.put(subs[0], tgroup++);
				groups.put(subs[1], groups.get(subs[0]));
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
			String[] isubs = id.split("!--!");
			jwn.name = isubs[0];
			jwn.title = isubs[1];
			jwn.group = groups.get(id);
			jwn.size = sizes.get(id);
			jwg.nodes.add(jwn);
		}
		eventsGraph = JSON.toJSONString(jwg);
	}
	
	

}
