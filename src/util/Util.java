package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Util {
	
	
	
	
	/**
	 * @param texts
	 * @return
	 * @Description:convert list to string
	 */
	public static String ListToStr(List<String> texts){
		String result = "";
		for(String text:texts ){
			result+=text;
		}		
		return result;
	}
	
	/**
	 * @param texts
	 * @return
	 * @Description:convert list to string
	 */
	public static String ListToStrForm(List<String> texts){
		String result = "";
		for(String text:texts ){
			result += "<p>    " + text + "</p>\n";
		}		
		return result;
	}
	
	/**
	 * @param texts
	 * @return
	 * @Description:convert list to string
	 */
	public static String ListToStr(List<String> texts,String split){
		String result = "";
		int num = 0;
		for(String text:texts ){
			num++;
			if(num == 1){
				result = text;
			}else{
				result += split +  text ;	
			}		
		}		
		return result;
	}
	
	/**
	 * @param texts
	 * @return
	 * @Description:convert list to string
	 */
	public static String ListToStr(List<String> texts,String split,int n){
		String result = "";
		int num = 0;
		for(String text:texts ){
			num++;
			if(num == 1){
				result = text;
			}else{
				result += split +  text ;	
			}		
			if(num > n)
				break;
		}		
		return result;
	}
	
	public static String MD5(String str){
		String result = "";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			  byte[] dataBytes = str.getBytes();
		      md.update(dataBytes);
		        byte[] mdbytes = md.digest();		 
		        //convert the byte to hex format method 1
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < mdbytes.length; i++) {
		          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
		        }
		        //convert the byte to hex format method 2
		        StringBuffer hexString = new StringBuffer();
		    	for (int i=0;i<mdbytes.length;i++) {
		    		String hex=Integer.toHexString(0xff & mdbytes[i]);
		   	     	if(hex.length()==1) hexString.append('0');
		   	     	hexString.append(hex);
		    	}
		    	result =  hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;     
	}
	
	public static String MD5OfByte(byte[] dataBytes){
		String result = "";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		      md.update(dataBytes);
		        byte[] mdbytes = md.digest();		 
		        //convert the byte to hex format method 1
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < mdbytes.length; i++) {
		          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
		        }
		        //convert the byte to hex format method 2
		        StringBuffer hexString = new StringBuffer();
		    	for (int i=0;i<mdbytes.length;i++) {
		    		String hex=Integer.toHexString(0xff & mdbytes[i]);
		   	     	if(hex.length()==1) hexString.append('0');
		   	     	hexString.append(hex);
		    	}
		    	result =  hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;     
	}
	
	//words string in db convert to map
	//format is "a,5 b,10" 
	public static  Map<String,Integer> getDdfMap(String words){
		Map<String,Integer> results = new HashMap<String,Integer>();
		String[] wds = words.split(" ");
		for(String wd : wds){
			if(wd.length() == 0)
				continue;
			String[] score = wd.split(",");
			results.put(score[0], Integer.valueOf(score[1]));
		}			
		return results;
	}
	
	///write map to str format
	public static String DdfMapToStr(Map<String,Integer> words){
		StringBuilder result = new StringBuilder();
		Iterator<String> its = words.keySet().iterator();
		while(its.hasNext()){
			String word = its.next();
			result.append(word + "," + words.get(word) + " ");
		}
		return result.toString();
	}

	public static void ArrayCopy(double a[][] , double b[][], int N, int M){
		for(int i = 0 ;i<N;i++){
			for(int j = 0 ;j<M;j++){
				a[i][j] = b[i][j];
			}
		}
	}
	
	public static String extractTimeFromText(String text){
		Pattern pattern = Pattern.compile("\\d{2,4}.\\d{1,2}.\\d{1,2}.?\\s*\\d{1,2}:\\d{1,2}:?\\d{0,2}");
		Matcher matcher = pattern.matcher(text);
		if(matcher.find()){
			return matcher.group().trim();
		}
		return "";
	}
	

	
	public static byte[] long2Byte(long x) { 
		byte[] res = new byte[8];
		res[ 0] = (byte) (x >> 56); 
		res[ 1] = (byte) (x >> 48); 
		res[ 2] = (byte) (x >> 40); 
		res[ 3] = (byte) (x >> 32); 
		res[ 4] = (byte) (x >> 24); 
		res[ 5] = (byte) (x >> 16); 
		res[ 6] = (byte) (x >> 8); 
		res[ 7] = (byte) (x >> 0); 
		return res;
  } 
	
	public static int getDayGMT8(Date dt){
		int res = 0;
		if(dt == null){
			return res;
		}
		res = (int)((dt.getTime() / 1000 / 60 / 60 + 8 ) / 24);
		return res;
	}
	
	public static String getDateStr(Date date){
		if(date == null){
			date = new Date();
		}
		String result = "";
		java.text.DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
	    result = format.format(date);
		return result;
	}

}
