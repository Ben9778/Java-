package Jiemian;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.*;
import javax.swing.*;
import Gonggong.*;
import Moxing.*;
public class Login extends JFrame implements ActionListener,MouseListener {
	JPanel a,a1;
	JLabel b,b1,b4,b5;
	JTextField wbk1;
	JPasswordField wbk2;
	JButton an1,an2;
	JCheckBox d,d1,d2;
	public Login() {
		this.setJPanel();
		this.setMb();
	}
	public void setJPanel() {
		//中部
		b=new JLabel("QQ号",JLabel.RIGHT);
		b1=new JLabel("密  码",JLabel.RIGHT);
		b4=new JLabel("<html><a href='www.aq.qq.com'>注册账号</a>");
		b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b4.setForeground(Color.blue);
		b4.addMouseListener(this);
		b5=new JLabel("<html><a href='www.aq.qq.com'>忘记密码</a>");
		b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b5.setForeground(Color.blue);
		b5.addMouseListener(this);
		wbk1=new JTextField(10);
		wbk2=new JPasswordField(10);
		d=new JCheckBox("记住密码");
		d1=new JCheckBox("自动登陆");
		d2=new JCheckBox("隐身登陆");
		d1.setAlignmentX(RIGHT_ALIGNMENT);
		a=new JPanel();
		a.setLayout(new GridLayout(3,1,5,5));
		a.add(b);a.add(wbk1);a.add(b4);
		a.add(b1);a.add(wbk2);a.add(b5);
		a.add(d); a.add(d1); a.add(d2);
		this.add(a);
		//南部
		an1=new JButton("登陆");
		an1.setForeground(Color.red);
		an1.addActionListener(this);
		an1.setActionCommand("login");
		an2=new JButton("取消");
		an2.setForeground(Color.red);
		an2.addActionListener(this);
		an2.setActionCommand("cancel");
		a1=new JPanel();
		a1.add(an1);a1.add(an2);
		this.add(a1,BorderLayout.SOUTH);
	}
	public void setMb() {
		this.setTitle("QQ登陆");
		this.setSize(260, 150);
		this.setLocation(300,280);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//主程序
	public static void main(String[] args) {
		new Login();
	}

	//事件监听
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("login")) {
			User u=new User();
			u.setUserID(wbk1.getText().trim());
			u.setPassword(String.valueOf(wbk2.getPassword()));
			//将用户名和密码发送到连接至服务器区验证
			Yanzheng yz=new Yanzheng();
			if(yz.CheckUser(u)) {
				Liebiao aa=new Liebiao(u.getUserID());
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "用户名或密码错误");
			}
		}else if(e.getActionCommand().equals("cancel")) {
			this.dispose();
		}
	}
	@Override
	public void mouseClicked(MouseEvent m) {
		if(m.getSource()==b4||m.getSource()==b5) {
			try {
				Desktop.getDesktop().browse(new java.net.URI("http://www.aq.qq.com"));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent m) {


	}
	@Override
	public void mouseExited(MouseEvent m) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent m) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent m) {
		// TODO Auto-generated method stub

	}

}
