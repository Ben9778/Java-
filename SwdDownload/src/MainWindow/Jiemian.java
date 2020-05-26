package MainWindow;
import java.applet.*;
import javax.swing.*;
import java.awt.*;
public class Jiemian extends JFrame  {
	JLabel bg;//背景
	JLabel center;
	JLabel swd1,swd2,swd3,swd4;
	public Jiemian() {
		this.setcenter();
		this.setbackground();
		this.setFrame();
		
	}
	//面板设置
	public void setFrame() {
		this.setSize(1200, 675);
		this.setLocation(100, 30);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//背景
	public void setbackground() {
		Icon i=new ImageIcon("Image/bg.jpg");
		bg=new JLabel(i);
		bg.setLayout(new BorderLayout());//背景JLabel设为边框布局
		center=new JLabel();
		center.setLayout(new GridLayout(4,3));//设置图片组件为流式布局
		//轩辕剑一
		Icon i1=new ImageIcon("Image/轩辕剑一.jpg");
		swd1=new JLabel(i1);
		//轩辕剑二
		Icon i2=new ImageIcon("Image/轩辕剑二.jpg");
		swd2=new JLabel(i2);
		//轩二枫之舞
		Icon i3=new ImageIcon("Image/轩二枫之舞.jpg");
		swd3=new JLabel(i3);
		//轩辕剑三
		Icon i4=new ImageIcon("Image/轩辕剑三.jpg");
		swd4=new JLabel(i4);
		
		center.add(swd1);center.add(swd2);center.add(swd3);
		center.add(swd4);
		
		bg.add(center,BorderLayout.CENTER);//将所有轩辕剑图片加入到中间
		this.add(bg);
	}
	//中部
	public void setcenter() {

	}
	public static void main(String[] args) {
		new Jiemian();
	}
}
