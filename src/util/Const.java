package util;

import java.util.HashMap;
import java.util.Map;

public class Const {
	
	public static Map<String,Integer> subtopicMap = new HashMap<String,Integer>();
	
	public static void loadSubtopicMap(){
		
		subtopicMap.put("main", 2);
		subtopicMap.put("����", 2);
		subtopicMap.put("china", 4);
		subtopicMap.put("����", 4);
		subtopicMap.put("world", 8);
		subtopicMap.put("����", 8);
		subtopicMap.put("society", 16);
		subtopicMap.put("���", 16);
		subtopicMap.put("military", 32);
		subtopicMap.put("����", 32);
		subtopicMap.put("health", 64);
		subtopicMap.put("����", 64);
		subtopicMap.put("sports", 128);
		subtopicMap.put("����", 128);
		subtopicMap.put("entertainment", 256);
		subtopicMap.put("����", 256);
		subtopicMap.put("finance", 512);
		subtopicMap.put("����", 512);
		subtopicMap.put("technology", 1024);
		subtopicMap.put("�Ƽ�", 1024);
		subtopicMap.put("education", 2048);
		subtopicMap.put("����", 2048);
		subtopicMap.put("law", 4096);
		subtopicMap.put("����", 4096);
	}

}
