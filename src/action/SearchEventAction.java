package action;

import index.EventIndex;

import java.util.ArrayList;
import java.util.List;

import db.Event;

public class SearchEventAction {
	
	private String EventQuery;
	private List<Event> results;
	
	private int SearchBatchSize = 30;
	

	
	public List<Event> getResults() {
		return results;
	}

	public void setResults(List<Event> results) {
		this.results = results;
	}
	

	public String getEventQuery() {
		return EventQuery;
	}

	public void setEventQuery(String eventQuery) {
		EventQuery = eventQuery;
	}

	public String showSearchResults(){
		System.out.println(EventQuery);
		if(EventQuery == null || EventQuery.length() == 0){
			return "success";
		}
		EventQuery = EventQuery.replace(" ", "");
		results = new ArrayList<Event>();
		EventIndex ei = new EventIndex();
		results = ei.queryEvents(EventQuery,-1,-1, 0, SearchBatchSize, null,"desc");
		return "success";
	}

}
