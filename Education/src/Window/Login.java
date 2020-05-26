package Window;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import Tools.*;
public class Login extends JFrame implements ActionListener,WindowListener{
	JLabel bg;//����ͼƬ
	JLabel user;//����Ա
	JLabel pw;//����
	JCheckBox c;//��ס�˺�
	JCheckBox d;//��ס����
	JButton dl;//��½��ť
	JButton qx;//ȡ����ť
	JTextField zh;//�˺������
	JPasswordField mm;//���������
	//���췽��
	public Login() {
		setComponent();	
		setBackGround();
		setWindow();
	}
	//��������
	public void setBackGround() {
		Icon im=new ImageIcon("Image/bg.jpg");
		bg=new JLabel(im);
		bg.setBounds(0, 0, 500, 450);
		this.add(bg);		
	}
	//�����������
	public void setComponent() {
		user=new JLabel("����Ա");
		user.setBounds(155, 140, 80, 80);
		user.setForeground(Color.WHITE);
		pw=new JLabel("��    ��");
		pw.setBounds(155, 165, 80, 80);
		pw.setForeground(Color.WHITE);
		zh=new JTextField(10);
		zh.setBounds(205, 170, 100, 20);
		mm=new JPasswordField(10);
		mm.setBounds(205, 195, 100, 20);
		dl=new JButton("��½");
		dl.setBounds(310, 170, 60, 20);
		dl.setForeground(Color.BLUE);
		dl.setBackground(Color.YELLOW);
		dl.setFocusPainted(false);
		dl.setCursor(new Cursor(Cursor.HAND_CURSOR));
		dl.addActionListener(this);
		qx=new JButton("ȡ��");
		qx.setBounds(310, 195, 60, 20);
		qx.setForeground(Color.BLUE);
		qx.setBackground(Color.YELLOW);
		qx.setFocusPainted(false);
		qx.setCursor(new Cursor(Cursor.HAND_CURSOR));
		qx.addActionListener(this);

//		c=new JCheckBox("��ס�˺�");
//		c.setBounds(155, 220, 90, 30);
//		c.setForeground(Color.white);
//		c.setContentAreaFilled(false);
//		
//		d=new JCheckBox("��ס����");
//		d.setBounds(240, 220, 90, 30);
//		d.setForeground(Color.white);
//		d.setContentAreaFilled(false);
		
		//���������������
		this.add(user);this.add(zh);
		this.add(pw);this.add(mm);
		this.add(dl);this.add(qx);
//		this.add(c);this.add(d);
	}
	//������������
	public void setWindow() {
		this.setLayout(null);
		this.setTitle("��ѧ����Ϣ����ϵͳ");
		this.setSize(500, 450);
		this.setLocation(420, 170);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//�����¼�����
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(dl)) {//�����¼��ť�Ĳ���
			CheckUser cu=new CheckUser();//��֤�˺ź�����
			if(cu.Check(zh.getText(),mm.getText())) {
				Interface t=new Interface();
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(null,"�û�����������������");
			}			
		}
		else if(e.getSource().equals(qx)) {//���ȡ����ť�Ĳ���
			this.dispose();
		}
	}		
	//������
	public static void main(String[] args) {
		new Login();
	}
	//���ڼ����¼�
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
