package windows;

import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServletSocket {
	String s;
	public ServletSocket() {
		try {
			//����������˿�
			DatagramSocket socket=new DatagramSocket(6666);
			byte[] bytes=new byte[1024];
			DatagramPacket request=new DatagramPacket(bytes,bytes.length);//��������
			socket.receive(request);
			s=new String(bytes,0,request.getLength());
//			System.out.println(s);
			
			InetAddress address=request.getAddress();//��ȡ���͵�ַ
			int port=request.getPort();//��ȡ���Ͷ˿�
			
			byte[] data="��Ҳ��".getBytes();
			DatagramPacket respone=new DatagramPacket(data,data.length,address,port);//��������
			socket.send(respone);
			System.out.println(port);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
