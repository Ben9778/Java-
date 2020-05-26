package Bean;

public class Fabulous {
	//这是一个管理点赞的类
	private String fabulous_ID;//点赞者名称
	private String byFabulous_ID;//被点赞的ID
	private long bookID;//所属商品的编号
	private long statistics;//统计点赞数
	
	public long getStatistics() {
		return statistics;
	}
	public void setStatistics(long statistics) {
		this.statistics = statistics;
	}
	public String getFabulous_ID() {
		return fabulous_ID;
	}
	public void setFabulous_ID(String fabulous_ID) {
		this.fabulous_ID = fabulous_ID;
	}
	public String getbyFabulous_ID() {
		return byFabulous_ID;
	}
	public void setbyFabulous_ID(String byFabulous_ID) {
		this.byFabulous_ID = byFabulous_ID;
	}
	public long getBookID() {
		return bookID;
	}
	public void setBookID(long bookID) {
		this.bookID = bookID;
	}
	
}
