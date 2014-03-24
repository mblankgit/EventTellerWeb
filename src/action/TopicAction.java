package action;

import java.util.ArrayList;
import java.util.List;

import db.Topic;
import db.TopicInfo;

public class TopicAction {
	
	
	private String type;
	private String pagenum;
	
	private List<Topic> topics;

	private final int BatchSize = 30;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPagenum() {
		return pagenum;
	}
	public void setPagenum(String pagenum) {
		this.pagenum = pagenum;
	}
	
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	@SuppressWarnings("unchecked")
	public String showTopics(){
		topics = new ArrayList<Topic>();
		if(type == null || type.length() == 0){
			type = "1";
		}
		if(pagenum == null || pagenum.length() == 0){
			pagenum = "1";
		}
		String sql = "from TopicInfo as obj order by obj.number desc";
		util.Db db = new util.Db();
		List<TopicInfo> tis = db.getElement(sql, (Integer.parseInt(pagenum) - 1 )* BatchSize, BatchSize);
		for(TopicInfo ti : tis){
			sql = "from Topic as obj where obj.id = " + ti.getId();
			Topic tp = (Topic) db.getElementById(sql);
			if(tp != null){
				topics.add(tp);
			}
		}
		db.close();
		System.out.println(type + "\t" + pagenum + "\t" + topics.size());
		return "success";
	}

}
