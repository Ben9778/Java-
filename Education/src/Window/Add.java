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
	JLabel xh;//ѧ��
	JLabel yx;//Ժϵ
	JLabel zy;//רҵ
	JLabel bj;//�༶
	JLabel mz;//����
	JLabel xm;//����
	JLabel xb;//�Ա�
	JLabel nl;//����
	JLabel jg;//����
	JLabel dz;//סַ
	JLabel dh;//��ϵ��ʽ
	JLabel mail;//����
	JLabel lxr;//������ϵ��
	JLabel lxrfs;//������ϵ�˵绰
	JLabel time;//��ѧʱ��
	JLabel picture;//��Ƭ
	JTextField xh1,xm1,xb1,nl1,jg1,dz1,dh1,mail1,lxr1,bj1,mz1,lxrfs1,time1;//�ı���
	JComboBox yx1;//Ժϵ������
	JComboBox zy1;//רҵ������
	String[] yx2= {"����ϵ","����ϵ","�����ϵ","����ϵ","����ϵ"};//ϵ��ѡ��
	String[] zy2= {"����","����","�ﾶ","��Ӿ","����","Ϸ��","������","�������","��Ƭ��","����ܹ�","ģ���·","������̲���",
			"���ʽ���","���","˰��","����Ӣ��","��������","����","����","����"};//רҵѡ��
	JButton send;//�ϴ���Ƭ
	JButton add;//���
	JButton qx;//ȡ��
	JPanel jp,jp1,jp2;
	JFileChooser jc;//ѡ���ϴ���Ƭ��·��
	//���캯��
	public Add() {
		setModule();
		setWindow();
	}
	//�������
	public void setWindow() {
		Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(500, 250);
		this.setLocation(450,230);
		this.setTitle("���ѧ��");
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	//�������
	public void setModule() {
		//Label���
		xh=new JLabel("ѧ��",JLabel.RIGHT);yx=new JLabel("Ժϵ",JLabel.RIGHT);
		zy=new JLabel("רҵ",JLabel.RIGHT);xm=new JLabel("����",JLabel.RIGHT);
		xb=new JLabel("�Ա�",JLabel.RIGHT);nl=new JLabel("����",JLabel.RIGHT);
		jg=new JLabel("����",JLabel.RIGHT);bj=new JLabel("�༶",JLabel.RIGHT);
		mz=new JLabel("����",JLabel.RIGHT);dh=new JLabel("��ϵ��ʽ",JLabel.RIGHT);
		lxr=new JLabel("������ϵ��",JLabel.RIGHT);lxrfs=new JLabel("��ϵ��ʽ",JLabel.RIGHT);
		mail=new JLabel("����",JLabel.RIGHT);time=new JLabel("��ѧʱ��",JLabel.RIGHT);
		dz=new JLabel("��ͥ��ַ",JLabel.RIGHT);
		//JTextField���
		xh1=new JTextField(15);lxrfs1=new JTextField(12);
		bj1=new JTextField(10);time1=new JTextField(10);
		xm1=new JTextField(10);xb1=new JTextField(10);
		nl1=new JTextField(10);jg1=new JTextField(10);
		mz1=new JTextField(10);;dh1=new JTextField(12);
		lxr1=new JTextField(10);dz1=new JTextField(20);
		mail1=new JTextField(10);
		//JComboBox���
		yx1=new JComboBox();
		zy1=new JComboBox();
		for(int i=0;i<yx2.length;i++) {
			yx1.addItem(yx2[i]);
		}
		yx1.setSelectedIndex(2);
		for(int i=0;i<zy2.length;i++) {
			zy1.addItem(zy2[i]);
		}

		//�в�JPanel
		jp=new JPanel();
		jp.setLayout(new GridLayout(5,6,5,5));
		jp.add(yx);jp.add(yx1);jp.add(zy);jp.add(zy1);jp.add(bj);jp.add(bj1);
		jp.add(xh);jp.add(xh1);jp.add(xm);jp.add(xm1);jp.add(xb);jp.add(xb1);
		jp.add(nl);jp.add(nl1);jp.add(mz);jp.add(mz1);jp.add(jg);jp.add(jg1);
		jp.add(dz);jp.add(dz1);jp.add(dh);jp.add(dh1);jp.add(mail);jp.add(mail1);
		jp.add(lxr);jp.add(lxr1);jp.add(lxrfs);jp.add(lxrfs1);jp.add(time);jp.add(time1);	
		//����JPanel
		send=new JButton("�ϴ���Ƭ");
		send.setFocusable(false);
		send.setForeground(Color.blue);
		send.addActionListener(this);//��Ӽ���
		picture=new JLabel("1�����",JLabel.CENTER);
		picture.setForeground(Color.GRAY);
		picture.setCursor(new Cursor(Cursor.HAND_CURSOR));
		picture.setVisible(true);
		picture.setBorder(BorderFactory.createEtchedBorder());//���ñ߿�
		jp1=new JPanel();
		jp1.setLayout(new GridLayout(2,1));
		jp1.add(picture);
		jp1.add(send);
		//�ϲ�JPanel
		add=new JButton("���");
		qx=new JButton("ȡ��");
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

	//�¼���������
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(send)) {//�����ϴ���Ƭ�Ĳ���
			jc=new JFileChooser();
			jc.setDialogTitle("ѡ��ͼƬ·��");
			jc.showOpenDialog(null);
			try {
				FileInputStream fis=new FileInputStream(jc.getSelectedFile());//�ֽ�������
				BufferedInputStream bis=new BufferedInputStream(fis);//������
				byte[] buffere=new byte[1024];//����
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
		else if(e.getSource().equals(add)) {//���������Ϣ�Ĳ���
			Connection ct=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			String sqlWord="Insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//sql�Ĳ������

			if(xh1.getText().isEmpty()||bj1.getText().isEmpty()||xm1.getText().isEmpty()
					||xb1.getText().isEmpty()||nl1.getText().isEmpty()||mz1.getText().isEmpty()
					||jg1.getText().isEmpty()||dh1.getText().isEmpty()||dz1.getText().isEmpty()
					||mail1.getText().isEmpty()||lxr1.getText().isEmpty()||lxrfs1.getText().isEmpty()
					||time1.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null,"������Ϣ����Ϊ�գ�");
				return;
			}
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
				ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=school","sa","123456");//�������ݿ�
				ps=ct.prepareStatement(sqlWord);//����SQL���
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
				JOptionPane.showMessageDialog(null,"���ѧ����Ϣ�ɹ�");
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
