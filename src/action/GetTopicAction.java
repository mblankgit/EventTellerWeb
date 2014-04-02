package action;

import java.util.ArrayList;
import java.util.List;

import db.Event;
import db.EventTopicRelation;
import db.Topic;

public class GetTopicAction {
	
	private int tid;
	private List<Event> events;
	private Topic tp;
	private List<String> words;
	private List<Integer> weights;
	
	private String hots;
	
	
	
	
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	public Topic getTp() {
		return tp;
	}

	public void setTp(Topic tp) {
		this.tp = tp;
	}
	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}
	

	public List<Integer> getWeights() {
		return weights;
	}

	public void setWeights(List<Integer> weights) {
		this.weights = weights;
	}

	public String getHots() {
		return hots;
	}

	public void setHots(String hots) {
		this.hots = hots;
	}

//	private void generateWords(Topic tp){
//		words = new ArrayList<String>();
//		weights = new ArrayList<Integer>();
//		if(tp != null){
//			String[] keys = tp.getKeyWords().split(",");
//			for(String key : keys){
//				String[] ws = key.split(":");
//				if(ws.length == 2){
//					words.add(ws[0]);
//					weights.add((int)(Double.parseDouble(ws[1]) * 1000));
//				}	
//			}
//		}
//	}
//	
//	private void generateDays(Topic tp){
//		hots = "[";
//		if(tp != null){
//			String[] keys = tp.getTimeNumber().split(",");
//			int num = 0;
//			for(String key : keys){
//				if(num != 0){
//					hots += ",";
//				}
//				num++;
//				key = key.replace(":", ",");
//				hots += "[" + key + "]";
//			}
//		}
//		hots += "]";
//	}
	

	@SuppressWarnings("unchecked")
	public String getTopic(){
		if(tid < 0 ){
			return "success";
		}
		util.Db db = new util.Db();
		String sql = "from EventTopicRelation as obj where obj.tid = " + tid;
		events = new ArrayList<Event>();
		List<EventTopicRelation> etrs = db.getElement(sql, 0, -1);
		for(EventTopicRelation etr : etrs){
			sql = "from Event as obj where obj.id = " + etr.getEid();
			Event et = (Event) db.getElementById(sql);
			if(et == null || (et.getContent() == null || et.getContent().length() < 10)){
				continue;
			}
			et.setContent(et.getContent().replace("!##!", "\n"));
			et.setContent(et.getContent().substring(0,Math.min(et.getContent().length(), 200)));
			events.add(et);
		}
		return "success";
	}
	
	

}
