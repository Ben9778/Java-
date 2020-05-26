package Dao;
import java.sql.*;
public class UpdateUser {
	private static String user;
	//修改用户密码
	public static void UpdatePassword(String password){
		Connection ct=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=User","sa","123456");//连接数据库
			ps=ct.prepareStatement("update users set password=? where UserName=?");//创建SQL语句
			ps.executeUpdate();
			ps.setString(1, password );
			ps.setString(2, user);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ct!=null) {
					ct.close();
				}
				if(ps!=null) {
					ps.close();
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}	
	}
	//修改用户邮箱
	public static void UpdateEmail(String email){
		Connection ct=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=User","sa","123456");//连接数据库
			ps=ct.prepareStatement("update users set email=? where UserName=?");//创建SQL语句
			ps.setString(1, email);
			ps.setString(2, user);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ct!=null) {
					ct.close();
				}
				if(ps!=null) {
					ps.close();
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}			
	}
}
