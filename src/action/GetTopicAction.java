package action;

import java.util.ArrayList;
import java.util.List;

import db.Event;
import db.EventTopicRelation;

public class GetTopicAction {
	
	private int tid;
	private List<Event> events;
	
	
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

	
	
	@SuppressWarnings("unchecked")
	public String getTopic(){
		if(tid < 0 ){
			return "success";
		}
		String sql = "from EventTopicRelation as obj where obj.tid = " + tid;
		util.Db db = new util.Db();
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
