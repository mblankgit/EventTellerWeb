package action;

import index.EventIndex;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import db.Event;

public class EventAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8709012649580737832L;
	/**
	 * 
	 */
	private String indate;
	private int subtopic;
	
	
	private List<Event> ets;
	

	public String getIndate() {
		return indate;
	}




	public void setIndate(String indate) {
		this.indate = indate;
	}




	public int getSubtopic() {
		return subtopic;
	}




	public void setSubtopic(int subtopic) {
		this.subtopic = subtopic;
	}

	public List<Event> getEts() {
		return ets;
	}

	public void setEts(List<Event> ets) {
		this.ets = ets;
	}

	
	private int getSubTopic(){
		if( subtopic < 0){
			return 2;
		}
		return (int) Math.pow(2, subtopic + 1);
	}


	public String getDayEventList(){
		int topic = getSubTopic();
		int batch = 50;
		ets = new ArrayList<Event>();
		Date dt = null;
		if(indate == null || indate.length() == 0){
			dt = new Date();
		}else{
			 java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
			 try {
				dt = format.parse(indate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		int to_day = util.Util.getDayGMT8(dt);
		EventIndex ei = new EventIndex();
		ets = ei.queryEvents(null,to_day,topic, 0, batch, "et_number", "desc");
		return "success";
	}

}
