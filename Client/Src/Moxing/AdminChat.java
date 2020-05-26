package Moxing;
import java.util.*;
import Jiemian.Chat;
public class AdminChat {
	public static HashMap hm=new HashMap<String,Chat>();
	public static void addChat(String ID,Chat ct) {
		hm.put(ID,ct);
	}
	public static Chat getChat(String ID) {
		return (Chat)hm.get(ID);
	}
}
