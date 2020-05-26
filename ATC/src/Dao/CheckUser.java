package Dao;
import java.sql.*;
import Bean.User;
public class CheckUser {
	
	//验证账户密码对错
	public User login(String userName,String password){
		Connection ct=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User user=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=ATC","sa","123456");//连接数据库
			ps=ct.prepareStatement("select * from users where userName=? and password=? ");//创建SQL语句"
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
