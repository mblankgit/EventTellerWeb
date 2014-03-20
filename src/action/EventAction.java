package action;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import db.Event;
import db.EventInfo;

public class EventAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8709012649580737832L;
	/**
	 * 
	 */
	private String indate;
	private String subtopic;
	
	
	private List<Event> ets;
	

	public String getIndate() {
		return indate;
	}




	public void setIndate(String indate) {
		this.indate = indate;
	}




	public String getSubtopic() {
		return subtopic;
	}




	public void setSubtopic(String subtopic) {
		this.subtopic = subtopic;
	}

	public List<Event> getEts() {
		return ets;
	}

	public void setEts(List<Event> ets) {
		this.ets = ets;
	}


	
	private int getSubTopic(){
		if( subtopic == null || subtopic == ""){
			return 2;
		}
		util.Const.loadSubtopicMap();
		return util.Const.subtopicMap.get(subtopic.toLowerCase());
	}


	@SuppressWarnings("unchecked")
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
		long to_day = util.Util.getDayGMT8(dt);
		
		String hql = "from EventInfo as obj where obj.day = " + to_day + "and obj.topic = " + topic + " order by obj.number desc";
		util.Db db = new util.Db();
		List<EventInfo> eis = db.getElement(hql, 0, batch);
		for(EventInfo ei : eis){
			String getet = "from Event as obj where obj.id = " + ei.getId();
			Event et = (Event) db.getElementById(getet);
			if(et == null || (et.getContent() == null || et.getContent().length() < 10)){
				continue;
			}
			et.setContent(et.getContent().replace("!##!", "<p>"));
			et.setContent(et.getContent().substring(0,Math.min(et.getContent().length(), 200)));
			ets.add(et);
		}
		
		
//		String hql = "from Event as obj where obj.day = " + to_day + " and obj.topic = " + topic + " order by obj.number desc ";
//		util.Db db = new util.Db();
//		ets = db.getElement(hql,0,batch);
//		for(Event et : ets){
//			if(et.getContent() == null || et.getContent().length() < 10){
//				continue;
//			}
//			et.setContent(et.getContent().replace("!##!", "<p>"));
//			et.setContent(et.getContent().substring(0,Math.min(et.getContent().length(), 200)));
//		}
		db.close();		
		return "success";
	}

}
