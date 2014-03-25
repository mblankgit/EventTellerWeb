package util;

import java.util.HashMap;
import java.util.Map;

public class Const {
	
	public static Map<String,Integer> subtopicMap = new HashMap<String,Integer>();
	
	public static void loadSubtopicMap(){
		
		subtopicMap.put("main", 2);
		subtopicMap.put("热门", 2);
		subtopicMap.put("china", 4);
		subtopicMap.put("国内", 4);
		subtopicMap.put("world", 8);
		subtopicMap.put("国外", 8);
		subtopicMap.put("society", 16);
		subtopicMap.put("社会", 16);
		subtopicMap.put("military", 32);
		subtopicMap.put("军事", 32);
		subtopicMap.put("health", 64);
		subtopicMap.put("健康", 64);
		subtopicMap.put("sports", 128);
		subtopicMap.put("体育", 128);
		subtopicMap.put("entertainment", 256);
		subtopicMap.put("娱乐", 256);
		subtopicMap.put("finance", 512);
		subtopicMap.put("金融", 512);
		subtopicMap.put("technology", 1024);
		subtopicMap.put("科技", 1024);
		subtopicMap.put("education", 2048);
		subtopicMap.put("教育", 2048);
		subtopicMap.put("law", 4096);
		subtopicMap.put("法律", 4096);
	}

}
