package action;

import java.util.ArrayList;
import java.util.List;

import db.Event;
import index.EventIndex;

public class GetEventsAction {
	
	private String ids;
	private List<Event> events;


	
	

	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	public List<Event> getEvents() {
		return events;
	}





	public String getEventsByIds(){
		if(ids == null || ids.length() == 0){
			return "success";
		}
		System.out.println(ids.length());
		events = new ArrayList<Event>();
		EventIndex ei = new EventIndex();
		String[] id = ids.split(";");
		for(String tid : id){
			Event et = ei.getEventById(Integer.parseInt(tid));
			if(et != null){
				events.add(et);
			}
		}
		System.out.println(events.size());
		return "success";
	}

}
