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
			//分配服务器端口
			DatagramSocket socket=new DatagramSocket(6666);
			byte[] bytes=new byte[1024];
			DatagramPacket request=new DatagramPacket(bytes,bytes.length);//接收数据
			socket.receive(request);
			s=new String(bytes,0,request.getLength());
//			System.out.println(s);
			
			InetAddress address=request.getAddress();//获取发送地址
			int port=request.getPort();//获取发送端口
			
			byte[] data="你也好".getBytes();
			DatagramPacket respone=new DatagramPacket(data,data.length,address,port);//发送数据
			socket.send(respone);
			System.out.println(port);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
