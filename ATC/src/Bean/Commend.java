package Bean;

public class Commend {
	private String commend_ID;//����������
	private String commend_time;//����ʱ��
	private String commend_content;//��������
	private long bookID;//�����۵���Ʒ���
	
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
