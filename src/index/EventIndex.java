package index;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
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
	
	
	@SuppressWarnings("deprecation")
	public List<Event> queryEvents(String queryStr,int start, int num,String sort, String order){
		List<Event> res = new ArrayList<Event>();
		SolrServer server = new HttpSolrServer(solrUrl);
		SolrQuery query =new SolrQuery();  
        query.setQuery(queryStr);
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
				String title = doc.getFieldValue("et_title").toString();
				String time = doc.getFieldValue("et_pubTime").toString();
				String summary = doc.getFieldValue("et_summary").toString();
				String number = doc.getFieldValue("et_number").toString();
				Event et = new Event();
				et.setId(id);
				et.setTitle(title);
				et.setPubtime(new Date(time));
				et.setContent(summary);
				et.setNumber(Integer.parseInt(number));
				res.add(et);
			}
		}catch(Exception e){
			System.out.println("error...");
			return res;
		}
		return res;
	}

}
