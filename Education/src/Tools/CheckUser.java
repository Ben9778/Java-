package Tools;
import java.sql.*;
import java.util.*;
public class CheckUser {
	private String u;//�û���
	private String p;//����
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	//���캯��
	public boolean Check(String user,String password) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=school","sa","123456");//�������ݿ�
			ps=ct.prepareStatement("select * from users");//��ѯ���ݿ�
			rs=ps.executeQuery();
			if(rs.next()) {
				u=rs.getString(1);//��ȡ���ݿ������û���
				p=rs.getString(2);//��ȡ���ݿ���������
			}
		} catch (Exception e) {}
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
			}catch (Exception e1) {}
		}
		if(user.equals(u)&&password.equals(p)) {
			return true;
		}else {
			return false;
		}
	}
}
