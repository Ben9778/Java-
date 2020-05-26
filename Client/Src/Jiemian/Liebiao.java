package Jiemian;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.*;
import Gonggong.*;
import Moxing.*;
public class Liebiao extends JFrame implements ActionListener,MouseListener {
	JButton an1,an2,an3;
	JButton an4,an5,an6;
	JPanel a,a1,a2;
	JPanel a3,a4,a5;
	JLabel[] b,b1;
	JScrollPane gd,gd1;
	CardLayout cl=new CardLayout();
	String ID;
	public Liebiao() {

	}
	public Liebiao(String ID) {
		this.ID=ID;
		this.setMB();
		this.setPanel();
	}
	public void setPanel() {
		//好友列表组件
		an1=new JButton("好友列表");
		an2=new JButton("陌生人");
		an3=new JButton("黑名单");
		an3.addActionListener(this);
		a=new JPanel();
		a.setLayout(new BorderLayout());
		a1=new JPanel();
		a1.setLayout(new GridLayout(30,1,0,5));
		a1.setBackground(Color.white);
		gd=new JScrollPane(a1);
		a2=new JPanel();
		a2.setLayout(new GridLayout(2,1));
		b=new JLabel[30];
		for(int i=0;i<b.length;i++) {
			Icon aa=new ImageIcon("image/mm.jpg");
			b[i]=new JLabel(i+1+"",aa,JLabel.LEFT);
			b[i].setEnabled(false);
			if(b[i].getText().equals(ID)) {
				b[i].setEnabled(true);
			}
			b[i].addMouseListener(this);
			a1.add(b[i]);
		}	
		a2.add(an2);
		a2.add(an3);
		a.add(an1,BorderLayout.NORTH);
		a.add(gd);
		a.add(a2,BorderLayout.SOUTH);
		//黑名单组件
		a3=new JPanel();
		a3.setLayout(new BorderLayout());
		a4=new JPanel();
		a4.setLayout(new GridLayout(3,1));
		an4=new JButton("好友列表");
		an4.addActionListener(this);
		an5=new JButton("陌生人");
		an6=new JButton("黑名单");
		a4.add(an4);
		a4.add(an5);
		a4.add(an6);
		a5=new JPanel();
		a5.setLayout(new GridLayout(10,1,0,5));
		a5.setBackground(Color.white);
		gd1=new JScrollPane(a5);
		b1=new JLabel[10];
		for(int i=0;i<b1.length;i++) {
			Icon aa=new ImageIcon("image/mm.jpg");
			b1[i]=new JLabel(i+1+"",aa,JLabel.LEFT);
			b1[i].setEnabled(false);	
			b1[i].addMouseListener(this);
			a5.add(b1[i]);
		}
		a3.add(a4,BorderLayout.NORTH);
		a3.add(gd1);
		this.add(a,"1");
		this.add(a3,"2");
	}
	public void setMB() {
		this.setLayout(cl);
		this.setTitle(ID);
		this.setSize(200, 500);
		this.setLocation(600, 200);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==an3) {
			cl.show(this.getContentPane(),"2");
		}else if(e.getSource()==an4) {
			cl.show(this.getContentPane(),"1");
		}

	}

	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==2) {
			String FriendID=((JLabel)e.getSource()).getText();
			Chat a=new Chat(ID,FriendID);
			AdminChat.addChat(ID+""+FriendID, a);
		}
	}		

	public void mouseEntered(MouseEvent e) {
		JLabel jl=(JLabel)e.getSource();
		jl.setForeground(Color.red);	
	}
	public void mouseExited(MouseEvent e) {
		JLabel jl=(JLabel)e.getSource();
		jl.setForeground(Color.black);	
	}
	public void mousePressed(MouseEvent e) {

	}
	public void mouseReleased(MouseEvent e) {

	}
}
