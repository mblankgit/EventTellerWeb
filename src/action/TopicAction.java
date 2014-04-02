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
	
	
	@SuppressWarnings("unchecked")
	public String showTopics(){
		topics = new ArrayList<Topic>();
		if(type == null || type.length() == 0){
			type = "1";
		}
		if(pagenum == null || pagenum.length() == 0){
			pagenum = "1";
		}
		String sql = "from TopicInfo as obj order by obj.endDay desc, obj.number desc";
		util.Db db = new util.Db();
		List<TopicInfo> tis = db.getElement(sql, (Integer.parseInt(pagenum) - 1 )* BatchSize, BatchSize);
		for(TopicInfo ti : tis){
			sql = "from Topic as obj where obj.id = " + ti.getId();
			Topic tp = (Topic) db.getElementById(sql);
			if(tp != null){
				tp.setSummary(processKeyWord(tp.getKeyWords(),10));
				topics.add(tp);
			}
		}
		db.close();
		System.out.println(type + "\t" + pagenum + "\t" + topics.size());
		return "success";
	}

}
