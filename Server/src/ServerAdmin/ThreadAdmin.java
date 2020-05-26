package ServerAdmin;
import java.util.*;
public class ThreadAdmin {
	public static HashMap<String,ServerThread> hm=new HashMap<String,ServerThread>();
		public static void addThread(String ID,ServerThread st) {
			hm.put(ID,st);
		}
		public static ServerThread getThread(String ID) {
			return (ServerThread)hm.get(ID);
		}
//		public static String getOnlineUser() {
//			Iterator it=hm.keySet().iterator();
//			String res="";
//			while(it.hasNext())
//			{
//				res+=it.next().toString()+" ";
//			}
//			return res;
//		}
}
