package Jiemian;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.*;
import javax.swing.*;
import Gonggong.*;
import Moxing.*;
public class Chat extends JFrame implements ActionListener
{
	JPanel a1;
	JTextArea c;
	JTextField c1;
	JButton b,b1;
	JScrollPane d,d1;
	String FriendID;
	String ID;
	String xinxi;
	Message ms=new Message();
	public Chat() {

	}
	public Chat(String ID,String FriendID) {
		this.FriendID=FriendID;
		this.ID=ID;
		setPanel();
		setMB();
	}
	public void setPanel() {
		//聊天信息显示区域
		c=new JTextArea();
		c.setBackground(Color.white);
		d=new JScrollPane(c);
		//信息输入区域
		a1=new JPanel();
		c1=new JTextField(10);
		c1.setBackground(Color.white);
		b=new JButton("发送");
		b.addActionListener(this);
		b1=new JButton("关闭");
		b1.addActionListener(this);
		d1=new JScrollPane(c1);
		a1.add(d1);a1.add(b);a1.add(b1);

		this.add(d,"Center");
		this.add(a1,"South");
	}
	public void setMB() {
		this.setTitle(FriendID);
		this.setSize(300, 230);
		this.setLocation(300, 200);
		this.setVisible(true);
	}
	//显示服务器发送来的信息
	public  void showMessage(Message m) {
		xinxi=(m.getCon());
		c.append(xinxi+"\r\n");
	}
	//事件监听
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b) {
			
			ms.setSender(ID);
			ms.setGetter(FriendID);
			ms.setCon(c1.getText());		
			try {
				ObjectOutputStream oos=new ObjectOutputStream
				(AdminThread.getThread(ID).getS().getOutputStream());
				oos.writeObject(ms);
				c.append(c1.getText()+"\r\n");
				c1.setText("");
			} catch (Exception e1) {
			}
		}else if(e.getSource()==b1) {
			this.dispose();
		}
	}
}
