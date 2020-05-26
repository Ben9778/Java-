package Service;

import Bean.Commend;
import Dao.Dao_Commend;

public class CommendService {
	//该方法是用于添加评论
	public void addCommend(long bookID,String commend_ID,String commend_content,String commend_time) {
		Dao_Commend commend=new Dao_Commend();
		commend.Isert_Commend(bookID, commend_ID, commend_content,commend_time);
	}
	//该方法是用于查询评论
	public Commend selectCommend(long bookID) {
		Dao_Commend commend=new Dao_Commend();
		Commend select=commend.selectCommend(bookID);
		return select;
	}
}
