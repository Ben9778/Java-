package ServerAdmin;
import java.io.*;
import java.net.Socket;
import Gonggong.*;
public class ServerThread extends Thread{
	Socket s;
	public ServerThread(Socket s) {
		this.s=s;
	}
	public void run() {
		while(true) {
			try {
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message ms=(Message)ois.readObject();
				ServerThread st=ThreadAdmin.getThread(ms.getGetter());
				ObjectOutputStream oos=new ObjectOutputStream(st.s.getOutputStream());
				oos.writeObject(ms);
			}
			catch (Exception e) {
			}
		}
	}
}


