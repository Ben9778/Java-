package Service;

import Bean.Commend;
import Dao.Dao_Commend;

public class CommendService {
	//�÷����������������
	public void addCommend(long bookID,String commend_ID,String commend_content,String commend_time) {
		Dao_Commend commend=new Dao_Commend();
		commend.Isert_Commend(bookID, commend_ID, commend_content,commend_time);
	}
	//�÷��������ڲ�ѯ����
	public Commend selectCommend(long bookID) {
		Dao_Commend commend=new Dao_Commend();
		Commend select=commend.selectCommend(bookID);
		return select;
	}
}
