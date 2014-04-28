package action;

import java.util.ArrayList;
import java.util.List;

import db.Event;
import db.EventTopicRelation;
import db.Topic;

public class GetTopicAction {
	
	private int tid;
	private List<Event> events;
	private String title;
	private Topic tp;
	private List<String> words;
	private List<Integer> weights;	
	private List<Integer> days;
	private List<Integer> numbers;
	private List<Event> timeevents;
	
	
	
	
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
	

	public List<Event> getTimeevents() {
		return timeevents;
	}

	public void setTimeevents(List<Event> timeevents) {
		this.timeevents = timeevents;
	}

	public List<Integer> getDays() {
		return days;
	}

	public void setDays(List<Integer> days) {
		this.days = days;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	private void generateWords(Topic tp){
		words = new ArrayList<String>();
		weights = new ArrayList<Integer>();
		if(tp != null){
			String[] keys = tp.getKeyWords().split(",");
			for(String key : keys){
				String[] ws = key.split(":");
				if(ws.length == 2){
					words.add(ws[0]);
					weights.add((int)(Double.parseDouble(ws[1]) * 1000));
				}	
			}
		}
	}
	
	private void generateDays(Topic tp){
		days = new ArrayList<Integer>();
		numbers = new ArrayList<Integer>();
		if(tp != null){
			String[] keys = tp.getTimeNumber().split(",");
			for(String key : keys){
				String[] its = key.split(":");
				if(its.length == 2){
					days.add(Integer.parseInt(its[0]));
					numbers.add(Integer.parseInt(its[1]));
				}
			}
		}
	}
	

	@SuppressWarnings("unchecked")
	public String getTopicEvents(){
		if(tid < 0 ){
			return "success";
		}
		util.Db db = new util.Db();
		String sql = "from EventTopicRelation as obj where obj.id.tid = " + tid;
		events = new ArrayList<Event>();
		List<EventTopicRelation> etrs = db.getElement(sql, 0, -1);
		for(EventTopicRelation etr : etrs){
			sql = "from Event as obj where obj.id = " + etr.getId().getEid();
			Event et = (Event) db.getElementById(sql);
			if(et == null || (et.getContent() == null || et.getContent().length() < 10)){
				continue;
			}
			et.setContent(et.getContent().replace("!##!", "\n"));
			et.setContent(et.getContent().substring(0,Math.min(et.getContent().length(), 200)));
			events.add(et);
		}
		System.out.println(events.size() + "\t" + tid);
		return "success";
	}
	
	public String getOneTopic(){
		if(tid < 0){
			return "success";
		}
		String sql = "from Topic as obj where obj.id = " + tid;
		util.Db db = new util.Db();
		tp = (Topic) db.getElementById(sql);
		generateDays(tp);
		generateWords(tp);
		title = processKeyWord(tp.getKeyWords(),10);
		tp.setSummary(title);
		db.close();
		return "success";
	}
	
	public String defaultLoad(){
		getOneTopic();
		getTopicEvents();
		return "success";
	}
	
	

}
