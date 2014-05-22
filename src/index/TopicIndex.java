package index;

import db.Topic;
import index.model.WebTopic;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import java.util.Date;

/**
 * Created by mblank on 2014/5/9.
 */
public class TopicIndex {
    private static String solrUrl = "http://222.29.197.239:8080/solrTopics";


    public WebTopic queryIds(String word){
        WebTopic wt = new WebTopic();
        Topic tp = new Topic();
        SolrServer server = new HttpSolrServer(solrUrl);
        SolrQuery query =new SolrQuery();
        query.setQuery("id:" + word);
        try {
            QueryResponse response = server.query(query);
            SolrDocumentList docs = response.getResults();
            if(docs.size() == 1){
                String id = docs.get(0).getFieldValue("id").toString();
                String keyWords = docs.get(0).getFieldValue("et_keyWords").toString();
                String summary = docs.get(0).getFieldValue("et_summary").toString();
                String number = docs.get(0).getFieldValue("et_number").toString();
                String main = docs.get(0).getFieldValue("et_main").toString();
                String object = docs.get(0).getFieldValue("et_object").toString();
                Date startTime = (Date)docs.get(0).getFieldValue("et_startTime");
                Date endTime = (Date)docs.get(0).getFieldValue("et_endTime");
                String events = docs.get(0).getFieldValue("et_events").toString();
                tp.setId(Integer.parseInt(id));
                tp.setKeyWords(keyWords);
                tp.setNumber(Integer.parseInt(number));
                tp.setMain(main);
                tp.setObject(object);
                tp.setStartTime(startTime);
                tp.setEndTime(endTime);
                tp.setSummary(summary);
                wt.tp = tp;
                wt.ids = events;
            }
        }catch(Exception e){
        	e.printStackTrace();
            return null;
        }
        return wt;
    }

//
//    public void deleteItem(String id){
//        SolrServer server = new HttpSolrServer(solrUrl);
//        try {
//            server.deleteById(id);
//            server.commit();
//        } catch (SolrServerException e) {
//            e.printStackTrace();
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteAll(){
//        SolrServer server = new HttpSolrServer(solrUrl);
//        String queryStr = "*:*";
//        try {
//            server.deleteByQuery(queryStr);
//            server.commit();
//        } catch (SolrServerException e) {
//            e.printStackTrace();
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//    }

}
