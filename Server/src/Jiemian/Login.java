package Jiemian;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import ServerAdmin.*;
public class Login extends JFrame implements ActionListener
{
	JButton a,a1;
	JPanel b;
	public Login() {
		a=new JButton("启动服务器");
		a.addActionListener(this);
		a1=new JButton("关闭服务器");
		a1.addActionListener(this);
		b=new JPanel();
		b.setLayout(new GridLayout(2,1,5,5));
		b.add(a);
		b.add(a1);
		this.add(b,"Center");
		this.setTitle("聊天服务器");
		this.setSize(120, 120);
		this.setLocation(500, 300);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Login();
	}

	//服务器监听
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==a) {
			Fuwu fw=new Fuwu();
		}else if(e.getSource()==a1) {
			System.exit(0);
		}
		
	}

}
