package Service;
import Dao.*;
public class RegistService {
	
	//�ж��û����Ƿ�ע��
	public boolean check(String name) {
		InsertUser insertUser=new InsertUser();
		boolean checkUser=insertUser.checkUser(name);
		if(checkUser) {
			return true;//�û��ѱ�ע��
		}
		return false;//���û�����ע��
	}
	//�û�ע��
	public void registUser(String userName,String password,String email) {
		InsertUser insertUser=new InsertUser();
		insertUser.regist(userName, password, email);
	}
}
