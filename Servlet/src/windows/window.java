package windows;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class window extends JFrame implements ActionListener{
	
	JTextArea text;//�ı���ʾ��
	JSplitPane sp;//�ָ���
	JMenuBar menubar;//�˵���
	JMenu file;//�ļ�һ��ѡ��
	JMenuItem on,off;//�����رն����˵�
	JPanel panel;
	JLabel time,count;//ͳ����������ʾ��ǰʱ��
	JSplitPane split=new JSplitPane();
	//���캯��
	public window() {
		setPane();
//		setright();
		setmain();
	}
	public void setmain() {
		this.setTitle("fireServlet");
		this.setSize(450, 300);
		this.setLocation(420, 150);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//��,�˵���
	public void setPane() {
		menubar=new JMenuBar();
		file=new JMenu("ѡ��");
		on=new JMenuItem("����");
		off=new JMenuItem("�ر�");
		on.addActionListener(this);
		off.addActionListener(this);
		file.add(on);
		file.add(off);
		menubar.add(file);
		
		this.add(menubar,BorderLayout.NORTH);
		
		panel=new JPanel();
		panel.setLayout(new BorderLayout());//��������߿��Ͳ���
		time=new JLabel();
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        String dateString = dateFormat.format(date);
        time.setText("��ǰϵͳʱ��:"+dateString);
        count=new JLabel();
        count.setText("��ǰ�����û�:"+"");
        panel.add(count,BorderLayout.NORTH);//ͳ�������Ϸ�
        panel.add(time,BorderLayout.SOUTH);//ʱ�������·�
       
//        this.add(panel,BorderLayout.EAST);
		//�У��ı���
		text=new JTextArea();
//		this.add(text);		
		
		split.setLeftComponent(text);
		split.setRightComponent(panel);
		split.setDividerLocation(250);
		split.setOneTouchExpandable(true);
		split.setDividerSize(10);
		split.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		this.add(split);
	}
	
	//�����¼�
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(on)) {
			ServletSocket aa=new ServletSocket();
			String ss=aa.s;
			text.append(ss);
		}else if(arg0.getSource().equals(off)) {
			this.dispose();
		}

	}
	//������
	public static void main(String[] args) {
			new window();
	}
}
