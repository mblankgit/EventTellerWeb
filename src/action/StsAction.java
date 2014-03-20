package action;


public class StsAction {
	
	private int UrlTotalCount;

	public int getUrlTotalCount() {
		return UrlTotalCount;
	}

	public void setUrlTotalCount(int urlTotalCount) {
		UrlTotalCount = urlTotalCount;
	}
	
	
	public String getUrlCount(){
		util.Db db = new util.Db();
		String query = "select count(*) from UrlStatus";
		UrlTotalCount = db.queryCount(query);
		return "success";
	}
	
	

}
