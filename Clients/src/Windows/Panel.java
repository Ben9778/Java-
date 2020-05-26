package Windows;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
public class Panel {

	public static void main(String[] args)throws Exception {
		InetAddress address=InetAddress.getLocalHost();
		int port=6666;
		byte[] data="你在干嘛".getBytes();  
		DatagramPacket request=new DatagramPacket(data,data.length,address,port);//发送数据
		DatagramSocket socket=new DatagramSocket();
		socket.send(request);//发送数据
		
		byte[] bytes=new byte[1024];
		DatagramPacket respone=new DatagramPacket(bytes,bytes.length);//接收数据
		socket.receive(respone);
		String s=new String(bytes,0,respone.getLength());
		System.out.println(s);
	}

}
