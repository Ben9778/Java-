package Moxing;
import Gonggong.*;
public class Yanzheng implements MessageFlag
{
	//验证客户端的用户密码
	public boolean CheckUser(User u) {		
			return new Lianjie().Send(u);
	}
}
