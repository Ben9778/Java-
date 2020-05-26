package Window;
import java.awt.*;

import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
public class Add extends JDialog implements ActionListener{
	JLabel xh;//学号
	JLabel yx;//院系
	JLabel zy;//专业
	JLabel bj;//班级
	JLabel mz;//民族
	JLabel xm;//姓名
	JLabel xb;//性别
	JLabel nl;//年龄
	JLabel jg;//籍贯
	JLabel dz;//住址
	JLabel dh;//联系方式
	JLabel mail;//邮箱
	JLabel lxr;//紧急联系人
	JLabel lxrfs;//紧急联系人电话
	JLabel time;//入学时间
	JLabel picture;//照片
	JTextField xh1,xm1,xb1,nl1,jg1,dz1,dh1,mail1,lxr1,bj1,mz1,lxrfs1,time1;//文本框
	JComboBox yx1;//院系下拉框
	JComboBox zy1;//专业下拉框
	String[] yx2= {"体育系","表演系","计算机系","经济系","外语系"};//系别选项
	String[] zy2= {"篮球","足球","田径","游泳","话剧","戏曲","芭蕾舞","软件开发","单片机","软件架构","模拟电路","软件工程测试",
			"国际金融","会计","税务","商务英语","商务日语","法语","韩语","德语"};//专业选项
	JButton send;//上传照片
	JButton add;//添加
	JButton qx;//取消
	JPanel jp,jp1,jp2;
	JFileChooser jc;//选择上传照片的路径
	//构造函数
	public Add() {
		setModule();
		setWindow();
	}
	//设置面板
	public void setWindow() {
		Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(500, 250);
		this.setLocation(450,230);
		this.setTitle("添加学生");
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	//设置组件
	public void setModule() {
		//Label组件
		xh=new JLabel("学号",JLabel.RIGHT);yx=new JLabel("院系",JLabel.RIGHT);
		zy=new JLabel("专业",JLabel.RIGHT);xm=new JLabel("姓名",JLabel.RIGHT);
		xb=new JLabel("性别",JLabel.RIGHT);nl=new JLabel("年龄",JLabel.RIGHT);
		jg=new JLabel("籍贯",JLabel.RIGHT);bj=new JLabel("班级",JLabel.RIGHT);
		mz=new JLabel("民族",JLabel.RIGHT);dh=new JLabel("联系方式",JLabel.RIGHT);
		lxr=new JLabel("紧急联系人",JLabel.RIGHT);lxrfs=new JLabel("联系方式",JLabel.RIGHT);
		mail=new JLabel("邮箱",JLabel.RIGHT);time=new JLabel("入学时间",JLabel.RIGHT);
		dz=new JLabel("家庭地址",JLabel.RIGHT);
		//JTextField组件
		xh1=new JTextField(15);lxrfs1=new JTextField(12);
		bj1=new JTextField(10);time1=new JTextField(10);
		xm1=new JTextField(10);xb1=new JTextField(10);
		nl1=new JTextField(10);jg1=new JTextField(10);
		mz1=new JTextField(10);;dh1=new JTextField(12);
		lxr1=new JTextField(10);dz1=new JTextField(20);
		mail1=new JTextField(10);
		//JComboBox组件
		yx1=new JComboBox();
		zy1=new JComboBox();
		for(int i=0;i<yx2.length;i++) {
			yx1.addItem(yx2[i]);
		}
		yx1.setSelectedIndex(2);
		for(int i=0;i<zy2.length;i++) {
			zy1.addItem(zy2[i]);
		}

		//中部JPanel
		jp=new JPanel();
		jp.setLayout(new GridLayout(5,6,5,5));
		jp.add(yx);jp.add(yx1);jp.add(zy);jp.add(zy1);jp.add(bj);jp.add(bj1);
		jp.add(xh);jp.add(xh1);jp.add(xm);jp.add(xm1);jp.add(xb);jp.add(xb1);
		jp.add(nl);jp.add(nl1);jp.add(mz);jp.add(mz1);jp.add(jg);jp.add(jg1);
		jp.add(dz);jp.add(dz1);jp.add(dh);jp.add(dh1);jp.add(mail);jp.add(mail1);
		jp.add(lxr);jp.add(lxr1);jp.add(lxrfs);jp.add(lxrfs1);jp.add(time);jp.add(time1);	
		//北部JPanel
		send=new JButton("上传照片");
		send.setFocusable(false);
		send.setForeground(Color.blue);
		send.addActionListener(this);//添加监听
		picture=new JLabel("1寸免冠",JLabel.CENTER);
		picture.setForeground(Color.GRAY);
		picture.setCursor(new Cursor(Cursor.HAND_CURSOR));
		picture.setVisible(true);
		picture.setBorder(BorderFactory.createEtchedBorder());//设置边框
		jp1=new JPanel();
		jp1.setLayout(new GridLayout(2,1));
		jp1.add(picture);
		jp1.add(send);
		//南部JPanel
		add=new JButton("添加");
		qx=new JButton("取消");
		add.setFocusable(false);
		qx.setFocusable(false);
		add.addActionListener(this);
		qx.addActionListener(this);
		jp2=new JPanel();
		jp2.add(add);jp2.add(qx);

		this.add(jp1,BorderLayout.NORTH);
		this.add(jp);
		this.add(jp2,BorderLayout.SOUTH);
	}

	//事件监听处理
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(send)) {//处理上传照片的操作
			jc=new JFileChooser();
			jc.setDialogTitle("选择图片路径");
			jc.showOpenDialog(null);
			try {
				FileInputStream fis=new FileInputStream(jc.getSelectedFile());//字节输入流
				BufferedInputStream bis=new BufferedInputStream(fis);//缓冲流
				byte[] buffere=new byte[1024];//缓冲
				int a=0; 
				String b = "";
				if(fis.read()>0) {
					a=bis.read(buffere);
					b=String.valueOf(a);
				}
				Icon ic=new ImageIcon(b);
				send.setIcon(ic);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource().equals(add)) {//处理添加信息的操作
			Connection ct=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			String sqlWord="Insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//sql的操作语句

			if(xh1.getText().isEmpty()||bj1.getText().isEmpty()||xm1.getText().isEmpty()
					||xb1.getText().isEmpty()||nl1.getText().isEmpty()||mz1.getText().isEmpty()
					||jg1.getText().isEmpty()||dh1.getText().isEmpty()||dz1.getText().isEmpty()
					||mail1.getText().isEmpty()||lxr1.getText().isEmpty()||lxrfs1.getText().isEmpty()
					||time1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"资料信息不能为空！");
				return;
			}
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
				ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=school","sa","123456");//连接数据库
				ps=ct.prepareStatement(sqlWord);//创建SQL语句
				ps.setString(1, xh1.getText());
				ps.setString(2, yx1.getSelectedItem().toString());
				ps.setString(3, zy1.getSelectedItem().toString());
				ps.setString(4, bj1.getText());
				ps.setString(5, xm1.getText());
				ps.setString(6, xb1.getText());
				ps.setString(7, nl1.getText());
				ps.setString(8, mz1.getText());
				ps.setString(9, jg1.getText());
				ps.setString(10,dz1.getText());
				ps.setString(11, dh1.getText());
				ps.setString(12, mail1.getText());
				ps.setString(13, lxr1.getText());
				ps.setString(14, lxrfs1.getText());
				ps.setString(15, time1.getText());
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null,"添加学生信息成功");
				this.dispose();
			}
			catch (Exception e2) {}
			finally {
				try {
					if(ct!=null) {
						ct.close();
					}
					if(ps!=null) {
						ps.close();
					}
					if(rs!=null) {
						rs.close();
					}

				}
				catch(Exception e3) {}
			}
		}else if(e.getSource().equals(qx)) {
			this.dispose();
		}
	}
}
