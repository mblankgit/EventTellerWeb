package index;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import db.Event;




public class EventIndex {
	
	
	private String solrUrl;
	
	public EventIndex(){
		solrUrl = "http://222.29.197.239:8080/solr";
	}
	
	public Event getEventById(int id){
		Event res = null;
		SolrServer server = new HttpSolrServer(solrUrl);
		SolrQuery query =new SolrQuery();
		query.setQuery("id:" + id);
		QueryResponse response;
		try {
			response = server.query(query);
			SolrDocumentList docs = response.getResults();	
			if(docs.size() == 1){
				SolrDocument doc = docs.get(0);
				String tl = doc.getFieldValue("et_title").toString();
				Date time = (Date)doc.getFieldValue("et_pubTime");
				String summary = doc.getFieldValue("et_summary").toString().replace("!##!", "\n");
				String number = doc.getFieldValue("et_number").toString();
				String imgs = doc.getFieldValue("et_imgs").toString();
				res = new Event();
				res.setId(id);
				res.setImgs(imgs);
				res.setTitle(tl);
				res.setPubTime(time);
				res.setContent(summary);
				res.setNumber(Integer.parseInt(number));
			}
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	
	public List<Event> queryEvents(String title,int day,int topic,int start, int num,String sort, String order){
		List<Event> res = new ArrayList<Event>();
		SolrServer server = new HttpSolrServer(solrUrl);
		SolrQuery query =new SolrQuery();
		if(title == null){
			query.setQuery("et_day:" + day);
		}else{
			query.setQuery("et_title:" + title);
		}
		if(day > 0){
			query.addFilterQuery("et_day" + ":" + day);
		}
		if(topic > 0){
			query.addFilterQuery("et_topic"+":" + topic);
		}
		query.setStart(start);
		query.setRows(num);
		if(sort != null){
			if(order.equals("asc")){
				query.setSort(sort, SolrQuery.ORDER.asc);		
			}else{
				query.setSort(sort, SolrQuery.ORDER.desc);
			}
		}
		try {
			QueryResponse response = server.query(query);
			SolrDocumentList docs = response.getResults();			
			for (SolrDocument doc : docs) { 
				int id = Integer.parseInt(doc.getFieldValue("id").toString());
				String tl = doc.getFieldValue("et_title").toString();
				Date time = (Date)doc.getFieldValue("et_pubTime");
				String summary = doc.getFieldValue("et_summary").toString().replace("!##!", "\n");
				String number = doc.getFieldValue("et_number").toString();
				Event et = new Event();
				et.setId(id);
				et.setTitle(tl);
				et.setPubTime(time);
				et.setContent(summary);
				et.setNumber(Integer.parseInt(number));
				res.add(et);
			}
		}catch(Exception e){
			System.out.println("error...");
			e.printStackTrace();
			return res;
		}
		return res;
	}

}
