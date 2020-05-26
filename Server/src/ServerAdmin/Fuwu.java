package ServerAdmin;
import java.io.*;
import java.net.*;
import Gonggong.*;
public class Fuwu {
	public Fuwu() {
		try {
			ServerSocket ss=new ServerSocket(8888);//服务器端口设置
			while(true) {
				Socket s=ss.accept();
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				User u=(User) ois.readObject();
				Message m=new Message();
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
					if(u.getPassword().equals("123123")) {
						m.setMesType("1");
						oos.writeObject(m);
						ServerThread st=new ServerThread(s);
						ThreadAdmin.addThread(u.getUserID(),st);
						st.start();
					}else {
						m.setMesType("2");
						oos.writeObject(m);
						s.close();
					}							
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
