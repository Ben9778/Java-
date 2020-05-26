package Service;

import Bean.User;
import Dao.CheckUser;

public class LoginService {

	public User login(String name, String password) {
		CheckUser checkUser=new CheckUser();
		User user = checkUser.login(name, password);
		return  user;
	}
}
