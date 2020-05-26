package Service;
import Dao.*;
public class RegistService {
	
	//判断用户名是否被注册
	public boolean check(String name) {
		InsertUser insertUser=new InsertUser();
		boolean checkUser=insertUser.checkUser(name);
		if(checkUser) {
			return true;//用户已被注册
		}
		return false;//新用户可以注册
	}
	//用户注册
	public void registUser(String userName,String password,String email) {
		InsertUser insertUser=new InsertUser();
		insertUser.regist(userName, password, email);
	}
}
