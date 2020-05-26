package Bean;

public class Commend {
	private String commend_ID;//评论者名称
	private String commend_time;//评论时间
	private String commend_content;//评论内容
	private long bookID;//被评论的商品编号
	
	public long getBookID() {
		return bookID;
	}
	public void setBookID(long bookID) {
		this.bookID = bookID;
	}
	public String getCommend_ID() {
		return commend_ID;
	}
	public void setCommend_ID(String commend_ID) {
		this.commend_ID = commend_ID;
	}
	public String getCommend_time() {
		return commend_time;
	}
	public void setCommend_time(String commend_time) {
		this.commend_time = commend_time;
	}
	public String getCommend_content() {
		return commend_content;
	}
	public void setCommend_content(String commend_content) {
		this.commend_content = commend_content;
	}
	
}
