package action;

import index.EventIndex;

import java.util.ArrayList;
import java.util.List;

import db.Event;

public class GetEventAction {
	
	private int eid;
	private Event curet;
	private List<String> imgs;
	private List<String> pas;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}
	
	

	public List<String> getImgs() {
		return imgs;
	}

	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}

	public List<String> getPas() {
		return pas;
	}

	public void setPas(List<String> pas) {
		this.pas = pas;
	}


	
	
	public Event getCuret() {
		return curet;
	}

	public void setCuret(Event curet) {
		this.curet = curet;
	}

	
	public void getImgs(Event et){
		
		imgs = new ArrayList<String>();
		pas = new ArrayList<String>();
		
		///get imgs
		if(et != null && et.getImgs().length() > 0){
			String[] tmps = et.getImgs().split("!##!");
			if(tmps.length > 1 && tmps[1].length() > 10){
				imgs.add(tmps[1]);
			}else if(tmps.length > 0 && tmps[0].length() > 10){
				imgs.add(tmps[0]);
			}
		}
		
		///get paragraphs
		if(et != null && et.getContent().length() > 0){
			String[] tmps = et.getContent().split("\n");
			for(String tmp : tmps){
				if(tmp.length() > 0){
					pas.add(tmp);
				}
			}
		}
	}

	public String getEvent(){
//		String sql = "from Event as obj where obj.id = " + eid;
//		util.Db db = new util.Db();
//		curet = (Event)(db.getElementById(sql));
		
		EventIndex ei = new EventIndex();
		curet = ei.getEventById(eid);
		
		getImgs(curet);		
//		db.close();
		return "success";
	}

}
