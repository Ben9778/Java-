package Window;
import java.sql.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;
public class ShowTable extends AbstractTableModel {
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Vector RowCount;//��¼
	Vector ColumnCount;//�ֶ�
	//�����вκ���
	public ShowTable(String s) {
		setsql(s);
	}
	//�����޲κ���
	public ShowTable() {
		setsql("select * from student");
	}
	//�������ݿ�
	public void setsql(String s) {
		//�ֶ�(��)
		ColumnCount=new Vector();
		//��¼(��)	
		RowCount=new Vector();
		
		ColumnCount.add("ѧ��");ColumnCount.add("Ժϵ");ColumnCount.add("רҵ");
		ColumnCount.add("�༶");ColumnCount.add("����");ColumnCount.add("�Ա�");
		ColumnCount.add("����");ColumnCount.add("����");ColumnCount.add("����");
		ColumnCount.add("��ͥ��ַ");ColumnCount.add("��ϵ��ʽ");ColumnCount.add("����");
		ColumnCount.add("������ϵ��");ColumnCount.add("��ϵ��ʽ");ColumnCount.add("��ѧʱ��");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=school","sa","123456");
			ps=ct.prepareStatement(s);
			rs=ps.executeQuery();
			while(rs.next()) {
				Vector Row=new Vector();
				Row.add(rs.getInt(1));//ѧ��
				Row.add(rs.getString(2));//Ժϵ
				Row.add(rs.getString(3));//רҵ
				Row.add(rs.getString(4));//�༶
				Row.add(rs.getString(5));//����
				Row.add(rs.getString(6));//�Ա�
				Row.add(rs.getInt(7));//����
				Row.add(rs.getString(8));//����
				Row.add(rs.getString(9));//����
				Row.add(rs.getString(10));//��ͥ��ַ
				Row.add(rs.getInt(11));//��ϵ��ʽ
				Row.add(rs.getString(12));//����
				Row.add(rs.getString(13));//������ϵ��
				Row.add(rs.getInt(14));//������ϵ�˷�ʽ
				Row.add(rs.getDate(15));//��ѧʱ��
				RowCount.add(Row);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
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
			catch(Exception e1){
				e1.printStackTrace();;
			}
		}
	}
	//AbstractTableModel������д
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return ColumnCount.size();
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return RowCount.size();
	}
	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return ((Vector)this.RowCount.get(row)).get(column);
	}
	public String getColumnName(int column)
	{
		return (String)this.ColumnCount.get(column);
	}
}
