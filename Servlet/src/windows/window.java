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
	
	JTextArea text;//文本显示域
	JSplitPane sp;//分割线
	JMenuBar menubar;//菜单栏
	JMenu file;//文件一级选项
	JMenuItem on,off;//启动关闭二级菜单
	JPanel panel;
	JLabel time,count;//统计人数与显示当前时间
	JSplitPane split=new JSplitPane();
	//构造函数
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
	//上,菜单栏
	public void setPane() {
		menubar=new JMenuBar();
		file=new JMenu("选项");
		on=new JMenuItem("启动");
		off=new JMenuItem("关闭");
		on.addActionListener(this);
		off.addActionListener(this);
		file.add(on);
		file.add(off);
		menubar.add(file);
		
		this.add(menubar,BorderLayout.NORTH);
		
		panel=new JPanel();
		panel.setLayout(new BorderLayout());//右面组件边框型布局
		time=new JLabel();
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        String dateString = dateFormat.format(date);
        time.setText("当前系统时间:"+dateString);
        count=new JLabel();
        count.setText("当前在线用户:"+"");
        panel.add(count,BorderLayout.NORTH);//统计在右上方
        panel.add(time,BorderLayout.SOUTH);//时间在右下方
       
//        this.add(panel,BorderLayout.EAST);
		//中，文本域
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
	
	//监听事件
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(on)) {
			ServletSocket aa=new ServletSocket();
			String ss=aa.s;
			text.append(ss);
		}else if(arg0.getSource().equals(off)) {
			this.dispose();
		}

	}
	//主程序
	public static void main(String[] args) {
			new window();
	}
}
