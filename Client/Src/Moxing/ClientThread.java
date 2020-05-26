package Moxing;
import java.net.*;
import java.io.*;
import Gonggong.*;
import Jiemian.*;
public class ClientThread extends Thread{
	private Socket s;

	public ClientThread(Socket s) {
		this.s=s;
	}

	public Socket getS() {
		return s;
	}

	public void setS(Socket s) {
		this.s = s;
	}

	public void run() {
		while(true) {
			try {				
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message m=(Message)ois.readObject();
				Chat ct=AdminChat.getChat(m.getGetter()+""+m.getSender());
				ct.showMessage(m);
			}
			catch(Exception e) {
			}
		}
	}
}
