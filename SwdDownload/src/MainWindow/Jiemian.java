package MainWindow;
import java.applet.*;
import javax.swing.*;
import java.awt.*;
public class Jiemian extends JFrame  {
	JLabel bg;//����
	JLabel center;
	JLabel swd1,swd2,swd3,swd4;
	public Jiemian() {
		this.setcenter();
		this.setbackground();
		this.setFrame();
		
	}
	//�������
	public void setFrame() {
		this.setSize(1200, 675);
		this.setLocation(100, 30);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//����
	public void setbackground() {
		Icon i=new ImageIcon("Image/bg.jpg");
		bg=new JLabel(i);
		bg.setLayout(new BorderLayout());//����JLabel��Ϊ�߿򲼾�
		center=new JLabel();
		center.setLayout(new GridLayout(4,3));//����ͼƬ���Ϊ��ʽ����
		//��ԯ��һ
		Icon i1=new ImageIcon("Image/��ԯ��һ.jpg");
		swd1=new JLabel(i1);
		//��ԯ����
		Icon i2=new ImageIcon("Image/��ԯ����.jpg");
		swd2=new JLabel(i2);
		//������֮��
		Icon i3=new ImageIcon("Image/������֮��.jpg");
		swd3=new JLabel(i3);
		//��ԯ����
		Icon i4=new ImageIcon("Image/��ԯ����.jpg");
		swd4=new JLabel(i4);
		
		center.add(swd1);center.add(swd2);center.add(swd3);
		center.add(swd4);
		
		bg.add(center,BorderLayout.CENTER);//��������ԯ��ͼƬ���뵽�м�
		this.add(bg);
	}
	//�в�
	public void setcenter() {

	}
	public static void main(String[] args) {
		new Jiemian();
	}
}
