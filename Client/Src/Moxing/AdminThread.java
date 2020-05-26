package Moxing;
import java.util.*;
public class AdminThread {
	public static HashMap hm=new HashMap<String,ClientThread>();
	public static void addThread(String ID,ClientThread ct) {
		hm.put(ID, ct);
	}
	public static ClientThread getThread(String ID) {
		return (ClientThread)hm.get(ID);
	}
}
