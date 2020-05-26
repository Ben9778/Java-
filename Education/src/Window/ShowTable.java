package Window;
import java.sql.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;
public class ShowTable extends AbstractTableModel {
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	Vector RowCount;//记录
	Vector ColumnCount;//字段
	//构造有参函数
	public ShowTable(String s) {
		setsql(s);
	}
	//构造无参函数
	public ShowTable() {
		setsql("select * from student");
	}
	//设置数据库
	public void setsql(String s) {
		//字段(列)
		ColumnCount=new Vector();
		//记录(行)	
		RowCount=new Vector();
		
		ColumnCount.add("学号");ColumnCount.add("院系");ColumnCount.add("专业");
		ColumnCount.add("班级");ColumnCount.add("姓名");ColumnCount.add("性别");
		ColumnCount.add("年龄");ColumnCount.add("民族");ColumnCount.add("籍贯");
		ColumnCount.add("家庭地址");ColumnCount.add("联系方式");ColumnCount.add("邮箱");
		ColumnCount.add("紧急联系人");ColumnCount.add("联系方式");ColumnCount.add("入学时间");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=school","sa","123456");
			ps=ct.prepareStatement(s);
			rs=ps.executeQuery();
			while(rs.next()) {
				Vector Row=new Vector();
				Row.add(rs.getInt(1));//学号
				Row.add(rs.getString(2));//院系
				Row.add(rs.getString(3));//专业
				Row.add(rs.getString(4));//班级
				Row.add(rs.getString(5));//姓名
				Row.add(rs.getString(6));//性别
				Row.add(rs.getInt(7));//年龄
				Row.add(rs.getString(8));//民族
				Row.add(rs.getString(9));//籍贯
				Row.add(rs.getString(10));//家庭地址
				Row.add(rs.getInt(11));//联系方式
				Row.add(rs.getString(12));//邮箱
				Row.add(rs.getString(13));//紧急联系人
				Row.add(rs.getInt(14));//紧急联系人方式
				Row.add(rs.getDate(15));//入学时间
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
	//AbstractTableModel方法重写
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
