package MainWindow;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;
public class Login extends JWindow implements ActionListener{
	JTextField User;
	JTextField Password;
	JButton dl,qc;
	JCheckBox a,a1;
	JLabel b,b1;
	JLabel bg;
	public Login() {
		setLogin();
		Mb();
	}
	public void Mb() {
		this.setLayout(null);
		this.setSize(500, 450);
		this.setLocation(400, 300);
		this.setVisible(true);
	}
	public void setLogin() {
		//����ͼƬ����
		Icon ic=new ImageIcon("image/bg.jpg");
		bg=new JLabel(ic);
		bg.setBounds(0, 0, 500, 450);
		this.add(bg);
		b=new JLabel("�û���");
		b1=new JLabel("��  ��");
		
	}
	//��������
	public void actionPerformed(ActionEvent e) {
		
		
	}
	public static void main(String[] args) {
		new Login();
	}
}
