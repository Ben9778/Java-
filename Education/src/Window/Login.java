package Window;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import Tools.*;
public class Login extends JFrame implements ActionListener,WindowListener{
	JLabel bg;//背景图片
	JLabel user;//管理员
	JLabel pw;//密码
	JCheckBox c;//记住账号
	JCheckBox d;//记住密码
	JButton dl;//登陆按钮
	JButton qx;//取消按钮
	JTextField zh;//账号输入框
	JPasswordField mm;//密码输入框
	//构造方法
	public Login() {
		setComponent();	
		setBackGround();
		setWindow();
	}
	//背景设置
	public void setBackGround() {
		Icon im=new ImageIcon("Image/bg.jpg");
		bg=new JLabel(im);
		bg.setBounds(0, 0, 500, 450);
		this.add(bg);		
	}
	//组件内容设置
	public void setComponent() {
		user=new JLabel("管理员");
		user.setBounds(155, 140, 80, 80);
		user.setForeground(Color.WHITE);
		pw=new JLabel("密    码");
		pw.setBounds(155, 165, 80, 80);
		pw.setForeground(Color.WHITE);
		zh=new JTextField(10);
		zh.setBounds(205, 170, 100, 20);
		mm=new JPasswordField(10);
		mm.setBounds(205, 195, 100, 20);
		dl=new JButton("登陆");
		dl.setBounds(310, 170, 60, 20);
		dl.setForeground(Color.BLUE);
		dl.setBackground(Color.YELLOW);
		dl.setFocusPainted(false);
		dl.setCursor(new Cursor(Cursor.HAND_CURSOR));
		dl.addActionListener(this);
		qx=new JButton("取消");
		qx.setBounds(310, 195, 60, 20);
		qx.setForeground(Color.BLUE);
		qx.setBackground(Color.YELLOW);
		qx.setFocusPainted(false);
		qx.setCursor(new Cursor(Cursor.HAND_CURSOR));
		qx.addActionListener(this);

//		c=new JCheckBox("记住账号");
//		c.setBounds(155, 220, 90, 30);
//		c.setForeground(Color.white);
//		c.setContentAreaFilled(false);
//		
//		d=new JCheckBox("记住密码");
//		d.setBounds(240, 220, 90, 30);
//		d.setForeground(Color.white);
//		d.setContentAreaFilled(false);
		
		//添加组件至面板容器
		this.add(user);this.add(zh);
		this.add(pw);this.add(mm);
		this.add(dl);this.add(qx);
//		this.add(c);this.add(d);
	}
	//窗口属性设置
	public void setWindow() {
		this.setLayout(null);
		this.setTitle("好学生信息管理系统");
		this.setSize(500, 450);
		this.setLocation(420, 170);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//监听事件处理
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(dl)) {//点击登录按钮的操作
			CheckUser cu=new CheckUser();//验证账号和密码
			if(cu.Check(zh.getText(),mm.getText())) {
				Interface t=new Interface();
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(null,"用户名或密码输入有误");
			}			
		}
		else if(e.getSource().equals(qx)) {//点击取消按钮的操作
			this.dispose();
		}
	}		
	//主程序
	public static void main(String[] args) {
		new Login();
	}
	//窗口监听事件
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void windowOpened(WindowEvent e1) {
		// TODO Auto-generated method stub
		if(c.getActionListeners()!=null) {
			ShowUser su=new ShowUser();
			zh.setText(su.getU());
		}else if(d.getActionListeners()!=null) {
			ShowUser su=new ShowUser();
			mm.setText(su.getP());
		}else if(c.getActionListeners()!=null&&d.getActionListeners()!=null) {
			ShowUser su=new ShowUser();
			zh.setText(su.getU());
			mm.setText(su.getP());
		}
	}
}
