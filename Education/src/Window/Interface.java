package Window;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.event.*;
import javax.swing.plaf.BorderUIResource;
import javax.swing.tree.*;
public class Interface extends JFrame implements ActionListener{
	//西面
	DefaultMutableTreeNode dmt;//地球学院根目录
	DefaultMutableTreeNode dmt1;//毕业管理根目录
	DefaultMutableTreeNode ty;//体育系
	DefaultMutableTreeNode by;//表演系
	DefaultMutableTreeNode jsj;//计算机系
	DefaultMutableTreeNode jj;//经济系
	DefaultMutableTreeNode wy;//外语系
	JTree root;//树型架构
	//南面
	JButton add;//添加学生
	JButton delete;//删除学生
	//北面
	JButton select;//查询
	JButton clear;//清空
	JLabel yx;//院系
	JLabel zy;//专业
	JLabel xh;//学号
	JLabel xm;//姓名
	JLabel xb;//性别
	JLabel nl;//年龄
	JLabel jg;//籍贯
	JTextField xh1,xm1,xb1,nl1,jg1;//7个文本框
	JComboBox yx1;//院系下拉框
	JComboBox zy1;//专业下拉框
	String[] yx2= {"体育系","表演系","计算机系","经济系","外语系"};//系别选项
	String[] zy2= {"篮球","足球","田径","游泳","话剧","戏曲","芭蕾舞","软件开发","单片机","软件架构","模拟电路","软件工程测试",
			"国际金融","会计","税务","商务英语","商务日语","法语","韩语","德语"};//专业选项
	//中部
	JTable jb;//显示学生信息的表格
	JScrollPane jsp;//滚动条
	ShowTable st;
	//构造函数
	public Interface() {
		setCenter();//中
		setNorth();//北
		setSouth();//南
		setWest();//西
		setWindow();//界面属性		 
	}
	//面板属性设置
	public void setWindow() {
		Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(ScreenSize);
		this.setLayout(null);
		this.setTitle("学生管理就用好学生");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//西面组件内容设置
	public void setWest() {
		//体育系
		ty=new DefaultMutableTreeNode("体育系");
		ty.add(new DefaultMutableTreeNode(new School("篮球")));
		ty.add(new DefaultMutableTreeNode(new School("足球")));
		ty.add(new DefaultMutableTreeNode(new School("田径")));
		ty.add(new DefaultMutableTreeNode(new School("游泳")));
		//表演系
		by=new DefaultMutableTreeNode("表演系");
		by.add(new DefaultMutableTreeNode(new School("话剧")));
		by.add(new DefaultMutableTreeNode(new School("戏曲")));
		by.add(new DefaultMutableTreeNode(new School("芭蕾舞")));
		//计算机系
		jsj=new DefaultMutableTreeNode("计算机系");
		jsj.add(new DefaultMutableTreeNode(new School("软件开发")));
		jsj.add(new DefaultMutableTreeNode(new School("单片机")));
		jsj.add(new DefaultMutableTreeNode(new School("软件架构")));
		jsj.add(new DefaultMutableTreeNode(new School("模拟电路")));
		jsj.add(new DefaultMutableTreeNode(new School("软件工程测试")));
		//经济系
		jj=new DefaultMutableTreeNode("经济系");
		jj.add(new DefaultMutableTreeNode(new School("国际金融")));
		jj.add(new DefaultMutableTreeNode(new School("会计")));
		jj.add(new DefaultMutableTreeNode(new School("税务")));
		//外语系
		wy=new DefaultMutableTreeNode("外语系");
		wy.add(new DefaultMutableTreeNode(new School("商务英语")));
		wy.add(new DefaultMutableTreeNode(new School("商务日语")));
		wy.add(new DefaultMutableTreeNode(new School("法语")));
		wy.add(new DefaultMutableTreeNode(new School("韩语")));
		wy.add(new DefaultMutableTreeNode(new School("德语")));
		//地球学院根目录
		dmt=new DefaultMutableTreeNode("地球学院");
		dmt.add(ty);
		dmt.add(by);
		dmt.add(jsj);
		dmt.add(jj);
		dmt.add(wy);
		//树型结构设置
		root=new JTree(dmt);
		root.setBounds(0, 0, 150, 750);
		root.setFocusable(false);
		this.add(root);
	}
	//南面组件内容设置
	public void setSouth() {
		add=new JButton("添加学生");
		add.setBounds(570, 650, 100, 30);
		add.setFocusable(false);
		add.addActionListener(this);
		delete=new JButton("删除学生");
		delete.setBounds(680, 650, 100, 30);
		delete.setFocusable(false);
		delete.addActionListener(this);
		this.add(add);
		this.add(delete);
	}
	//北面组件内容设置
	public void setNorth() {
		yx=new JLabel("院系");yx1=new JComboBox();
		zy=new JLabel("专业");zy1=new JComboBox();
		xh=new JLabel("学号");xh1=new JTextField(15);
		xm=new JLabel("姓名");xm1=new JTextField(10);
		xb=new JLabel("性别");xb1=new JTextField(5);
		nl=new JLabel("年龄");nl1=new JTextField(5);
		jg=new JLabel("籍贯");jg1=new JTextField(10);
		for(int i=0;i<yx2.length;i++) {//添加院系下拉框选项
			yx1.addItem(yx2[i]);
		}
		yx1.setSelectedIndex(2);
		for(int i=0;i<zy2.length;i++) {//添加专业下拉框选项
			zy1.addItem(zy2[i]);
		}
		select=new JButton("查询");clear=new JButton("清空");
		yx.setBounds(190, 10, 50, 50);yx1.setBounds(220, 23, 80, 25);
		zy.setBounds(320, 10, 50, 50);zy1.setBounds(350, 23, 80, 25);
		xh.setBounds(450, 10, 50, 50);xh1.setBounds(480, 23, 130, 25);
		xm.setBounds(630, 10, 50, 50);xm1.setBounds(660, 23, 80, 25);
		xb.setBounds(760, 10, 50, 50);xb1.setBounds(790, 23, 80, 25);
		nl.setBounds(890, 10, 50, 50);nl1.setBounds(920, 23, 80, 25);
		jg.setBounds(1020, 10, 50, 50);jg1.setBounds(1050, 23, 80, 25);
		select.setBounds(600,70, 60, 30);clear.setBounds(700, 70, 60,30);
		select.setFocusable(false);clear.setFocusable(false);
		select.addActionListener(this);clear.addActionListener(this);
		this.add(yx);this.add(yx1);this.add(zy);this.add(zy1);this.add(xh);this.add(xh1);
		this.add(xm);this.add(xm1);this.add(xb);this.add(xb1);this.add(nl);this.add(nl1);
		this.add(jg);this.add(jg1);this.add(select);this.add(clear);
	}
	//中部表格组件
	public void setCenter() {
		st=new ShowTable();
		jb=new JTable(st);
		jb.setVisible(true);
		jsp=new JScrollPane(jb);
		jsp.setBounds(200, 130, 1100, 500);
		this.add(jsp);
	}

	//按钮监听事件处理
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(add)) {//添加学生
			Add a=new Add();
			if(a.add.isFocusable()) {
				st=new ShowTable();
				jb.setModel(st);
			}
		}
		else if(e.getSource().equals(clear)) {//清空筛选内容
			xh1.setText("");
			xm1.setText("");
			xb1.setText("");
			nl1.setText("");
			jg1.setText("");
		}
		else if(e.getSource().equals(delete)) {//删除学生
			int i=jb.getSelectedRow();
			if(i==(-1)) {
				JOptionPane.showMessageDialog(this,"请选择要删除的行");
			}
			int t=(int)st.getValueAt(i, 0);
			Connection ct=null;
			PreparedStatement ps=null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=school","sa", "123456");
				ps=ct.prepareStatement("delete from student where xh=?");
				ps.setInt(1,t);
				ps.executeUpdate();
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
			finally {
				try {
					if(ct!=null) {
						ct.close();
					}
					if(ps!=null) {
						ps.close();
					}
				}catch (Exception e2) {
					e2.printStackTrace();
				}
			}		
			st=new ShowTable();
			jb.setModel(st);
		}else if(e.getSource().equals(select)) {//查询

		}
	}
	//主程序
	public static void main(String[] args) {
		new Interface();
	}
}
//学校组织架构名称的类
class School{
	private String name;
	public School(String name) {
		this.name=name;
	}
	public String toString() {
		return name;
	}
}