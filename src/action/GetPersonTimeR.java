package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import model.JsonWordGraph;
import model.JsonWordLink;
import model.JsonWordNode;
import model.relation.Person;
import model.relation.WordSims;
import util.HttpRequest;

public class GetPersonTimeR {

	private String name;
	private Integer persent;
	private String personGraph;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPersent() {
		return persent;
	}
	public void setPersent(Integer persent) {
		this.persent = persent;
	}
	
	public String getPersonGraph() {
		return personGraph;
	}
	public void setPersonGraph(String personGraph) {
		this.personGraph = personGraph;
	}
	
	private void processPersonGraph(String word,Person ps){
		int tid = 0,tgroup = 2;
		HashMap<String,Integer> idIndex = new HashMap<String,Integer>();
		HashMap<String,Integer> groups = new HashMap<String,Integer>();
		HashMap<String,Double> sizes = new HashMap<String,Double>();
		List<String> ids = new ArrayList<String>();
		JsonWordGraph jwg = new JsonWordGraph();
		
		for(WordSims ws : ps.relations){			
			double tval = ws.score * 10;
			if(tval < 4){
				continue;
			}
			JsonWordLink jwl = new JsonWordLink();
			Integer indexa = null;
			Integer indexb = null;
			if(ws.worda.equals(word)){
				sizes.put(ws.wordb, 18.0);
				sizes.put(ws.worda, 30.0);
				if(!groups.containsKey(ws.wordb)){
					groups.put(ws.wordb, tgroup++);
				}
			}else{
				sizes.put(ws.wordb,10.0);
				if(groups.containsKey(ws.worda)){
					groups.put(ws.wordb, groups.get(ws.worda));
				}else{
					groups.put(ws.worda, tgroup++);
					groups.put(ws.wordb, groups.get(ws.worda));
				}				
			}
			if(idIndex.containsKey(ws.worda)){
				indexa = idIndex.get(ws.worda);
			}else{
				ids.add(ws.worda);
				indexa = tid++;
				idIndex.put(ws.worda, indexa);
			}
			if(idIndex.containsKey(ws.wordb)){
				indexb = idIndex.get(ws.wordb);
			}else{
				ids.add(ws.wordb);
				indexb = tid++;
				idIndex.put(ws.wordb, indexb);
			}
			jwl.target = indexa;
			jwl.source = indexb;
			jwl.value = tval;
			jwg.links.add(jwl);
		}
		groups.put(word, 1);
		sizes.put(word,30.0);
		for(String id : ids){
			JsonWordNode jwn = new JsonWordNode();
			jwn.name = id;
			jwn.group = groups.get(id);
			jwn.size = sizes.get(id);
			jwg.nodes.add(jwn);
		}
		personGraph = JSON.toJSONString(jwg);
	}
	
	public String getRelations(){
		if(name == null || persent == null){
			return "failed";
		}
		//pass name and persent to data server and get results back;
		String answer = HttpRequest.sendGet("http://10.77.50.245:8011/", "input=" + name + "&function=timePersonGraph&persent=" + persent);
		Person ps = JSONObject.parseObject(answer,Person.class);
		processPersonGraph(name,ps);
		return "success";
	}
	
	
	
	
}
