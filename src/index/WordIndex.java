package index;


import index.model.WebWord;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;


/**
 * Created by mblank on 14-4-25.
 */
public class WordIndex {
    private static String solrUrl;

    public WordIndex(){
        solrUrl = "http://222.29.197.239:8080/solrRelations";
    }


    public WebWord queryIds(String word){

    	WebWord res = new WebWord();
        SolrServer server = new HttpSolrServer(solrUrl);
        SolrQuery query =new SolrQuery();
        query.setQuery("id:" + word);
        try {
            QueryResponse response = server.query(query);
            SolrDocumentList docs = response.getResults();
            if(docs.size() == 1){
                String name = docs.get(0).getFieldValue("id").toString();
                String timeLine = docs.get(0).getFieldValue("web_wordTime").toString();
                String related = docs.get(0).getFieldValue("web_relatedWord").toString();
                String graph = docs.get(0).getFieldValue("web_graph").toString();
                String topicRelatedWords = docs.get(0).getFieldValue("web_topicRelatedWords").toString();
                res.setName(name);
                res.setWordTimeNumber(timeLine);
                res.setRelatedWords(related);
                res.setPersonGraph(graph);
                res.setTopicRelatedWords(topicRelatedWords);
            }
        }catch(Exception e){
        	e.printStackTrace();
            return null;
        }
        return res;
    }

}
