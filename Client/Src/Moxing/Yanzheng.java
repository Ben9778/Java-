package Moxing;
import Gonggong.*;
public class Yanzheng implements MessageFlag
{
	//��֤�ͻ��˵��û�����
	public boolean CheckUser(User u) {		
			return new Lianjie().Send(u);
	}
}
