package Moxing;
import java.io.*;
import java.net.*;
import java.util.*;
import Gonggong.*;
public class Lianjie 
{
	public Socket s;
	public boolean Send(Object o) {
		try {
			s=new Socket("Localhost",8888);
			
				//发送信息到服务器
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				oos.writeObject(o);
				//接收服务器发送的信息
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message ms=(Message)ois.readObject();
				if(ms.getMesType().equals("1")) {	
					ClientThread ct=new ClientThread(s);
					ct.start();
					AdminThread.addThread(((User)o).getUserID(), ct);
					return true;
				}
			
		}
		catch(Exception e) {

		}
		return false;
	}
}
