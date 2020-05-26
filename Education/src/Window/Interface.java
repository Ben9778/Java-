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
	//����
	DefaultMutableTreeNode dmt;//����ѧԺ��Ŀ¼
	DefaultMutableTreeNode dmt1;//��ҵ������Ŀ¼
	DefaultMutableTreeNode ty;//����ϵ
	DefaultMutableTreeNode by;//����ϵ
	DefaultMutableTreeNode jsj;//�����ϵ
	DefaultMutableTreeNode jj;//����ϵ
	DefaultMutableTreeNode wy;//����ϵ
	JTree root;//���ͼܹ�
	//����
	JButton add;//����ѧ��
	JButton delete;//ɾ��ѧ��
	//����
	JButton select;//��ѯ
	JButton clear;//���
	JLabel yx;//Ժϵ
	JLabel zy;//רҵ
	JLabel xh;//ѧ��
	JLabel xm;//����
	JLabel xb;//�Ա�
	JLabel nl;//����
	JLabel jg;//����
	JTextField xh1,xm1,xb1,nl1,jg1;//7���ı���
	JComboBox yx1;//Ժϵ������
	JComboBox zy1;//רҵ������
	String[] yx2= {"����ϵ","����ϵ","�����ϵ","����ϵ","����ϵ"};//ϵ��ѡ��
	String[] zy2= {"����","����","�ﾶ","��Ӿ","����","Ϸ��","������","��������","��Ƭ��","�����ܹ�","ģ���·","�������̲���",
			"���ʽ���","���","˰��","����Ӣ��","��������","����","����","����"};//רҵѡ��
	//�в�
	JTable jb;//��ʾѧ����Ϣ�ı���
	JScrollPane jsp;//������
	ShowTable st;
	//���캯��
	public Interface() {
		setCenter();//��
		setNorth();//��
		setSouth();//��
		setWest();//��
		setWindow();//��������		 
	}
	//�����������
	public void setWindow() {
		Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(ScreenSize);
		this.setLayout(null);
		this.setTitle("ѧ���������ú�ѧ��");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//���������������
	public void setWest() {
		//����ϵ
		ty=new DefaultMutableTreeNode("����ϵ");
		ty.add(new DefaultMutableTreeNode(new School("����")));
		ty.add(new DefaultMutableTreeNode(new School("����")));
		ty.add(new DefaultMutableTreeNode(new School("�ﾶ")));
		ty.add(new DefaultMutableTreeNode(new School("��Ӿ")));
		//����ϵ
		by=new DefaultMutableTreeNode("����ϵ");
		by.add(new DefaultMutableTreeNode(new School("����")));
		by.add(new DefaultMutableTreeNode(new School("Ϸ��")));
		by.add(new DefaultMutableTreeNode(new School("������")));
		//�����ϵ
		jsj=new DefaultMutableTreeNode("�����ϵ");
		jsj.add(new DefaultMutableTreeNode(new School("��������")));
		jsj.add(new DefaultMutableTreeNode(new School("��Ƭ��")));
		jsj.add(new DefaultMutableTreeNode(new School("�����ܹ�")));
		jsj.add(new DefaultMutableTreeNode(new School("ģ���·")));
		jsj.add(new DefaultMutableTreeNode(new School("�������̲���")));
		//����ϵ
		jj=new DefaultMutableTreeNode("����ϵ");
		jj.add(new DefaultMutableTreeNode(new School("���ʽ���")));
		jj.add(new DefaultMutableTreeNode(new School("���")));
		jj.add(new DefaultMutableTreeNode(new School("˰��")));
		//����ϵ
		wy=new DefaultMutableTreeNode("����ϵ");
		wy.add(new DefaultMutableTreeNode(new School("����Ӣ��")));
		wy.add(new DefaultMutableTreeNode(new School("��������")));
		wy.add(new DefaultMutableTreeNode(new School("����")));
		wy.add(new DefaultMutableTreeNode(new School("����")));
		wy.add(new DefaultMutableTreeNode(new School("����")));
		//����ѧԺ��Ŀ¼
		dmt=new DefaultMutableTreeNode("����ѧԺ");
		dmt.add(ty);
		dmt.add(by);
		dmt.add(jsj);
		dmt.add(jj);
		dmt.add(wy);
		//���ͽṹ����
		root=new JTree(dmt);
		root.setBounds(0, 0, 150, 750);
		root.setFocusable(false);
		this.add(root);
	}
	//���������������
	public void setSouth() {
		add=new JButton("����ѧ��");
		add.setBounds(570, 650, 100, 30);
		add.setFocusable(false);
		add.addActionListener(this);
		delete=new JButton("ɾ��ѧ��");
		delete.setBounds(680, 650, 100, 30);
		delete.setFocusable(false);
		delete.addActionListener(this);
		this.add(add);
		this.add(delete);
	}
	//���������������
	public void setNorth() {
		yx=new JLabel("Ժϵ");yx1=new JComboBox();
		zy=new JLabel("רҵ");zy1=new JComboBox();
		xh=new JLabel("ѧ��");xh1=new JTextField(15);
		xm=new JLabel("����");xm1=new JTextField(10);
		xb=new JLabel("�Ա�");xb1=new JTextField(5);
		nl=new JLabel("����");nl1=new JTextField(5);
		jg=new JLabel("����");jg1=new JTextField(10);
		for(int i=0;i<yx2.length;i++) {//����Ժϵ������ѡ��
			yx1.addItem(yx2[i]);
		}
		yx1.setSelectedIndex(2);
		for(int i=0;i<zy2.length;i++) {//����רҵ������ѡ��
			zy1.addItem(zy2[i]);
		}
		select=new JButton("��ѯ");clear=new JButton("���");
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
	//�в��������
	public void setCenter() {
		st=new ShowTable();
		jb=new JTable(st);
		jb.setVisible(true);
		jsp=new JScrollPane(jb);
		jsp.setBounds(200, 130, 1100, 500);
		this.add(jsp);
	}

	//��ť�����¼�����
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(add)) {//����ѧ��
			Add a=new Add();
			if(a.add.isFocusable()) {
				st=new ShowTable();
				jb.setModel(st);
			}
		}
		else if(e.getSource().equals(clear)) {//���ɸѡ����
			xh1.setText("");
			xm1.setText("");
			xb1.setText("");
			nl1.setText("");
			jg1.setText("");
		}
		else if(e.getSource().equals(delete)) {//ɾ��ѧ��
			int i=jb.getSelectedRow();
			if(i==(-1)) {
				JOptionPane.showMessageDialog(this,"��ѡ��Ҫɾ������");
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
		}else if(e.getSource().equals(select)) {//��ѯ

		}
	}
	//������
	public static void main(String[] args) {
		new Interface();
	}
}
//ѧУ��֯�ܹ����Ƶ���
class School{
	private String name;
	public School(String name) {
		this.name=name;
	}
	public String toString() {
		return name;
	}
}