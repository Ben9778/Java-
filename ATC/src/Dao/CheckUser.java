package Dao;
import java.sql.*;
import Bean.User;
public class CheckUser {
	
	//��֤�˻�����Դ�
	public User login(String userName,String password){
		Connection ct=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User user=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=ATC","sa","123456");//�������ݿ�
			ps=ct.prepareStatement("select * from users where userName=? and password=? ");//����SQL���"
			ps.setString(1,userName);
			ps.setString(2, password);
			rs=ps.executeQuery();
			while(rs.next()) {
				user=new User();
				user.setUserName(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setEmail(rs.getString(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ct!=null) {
					ct.close();
				}
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		return user;
	}
}
