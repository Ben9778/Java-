package Windows;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
public class Panel {

	public static void main(String[] args)throws Exception {
		InetAddress address=InetAddress.getLocalHost();
		int port=6666;
		byte[] data="���ڸ���".getBytes();  
		DatagramPacket request=new DatagramPacket(data,data.length,address,port);//��������
		DatagramSocket socket=new DatagramSocket();
		socket.send(request);//��������
		
		byte[] bytes=new byte[1024];
		DatagramPacket respone=new DatagramPacket(bytes,bytes.length);//��������
		socket.receive(respone);
		String s=new String(bytes,0,respone.getLength());
		System.out.println(s);
	}

}
