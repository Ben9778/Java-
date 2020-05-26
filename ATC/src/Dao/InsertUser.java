package Dao;
import java.sql.*;
import javax.servlet.jsp.jstl.sql.Result;
public class InsertUser {
	//判断用户名是否存在
	public boolean checkUser(String name) {
		Connection ct=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=ATC","sa","123456");//连接数据库
			ps=ct.prepareStatement("select * from users where userName=? ");//创建SQL语句
			ps.setString(1, name);
			rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
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
				if(rs!=null) {
					rs.close();
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}	
		return false;
	}
	//添加注册用户信息
	public void regist(String userName,String password,String email){
		Connection ct=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=ATC","sa","123456");//连接数据库
			ps=ct.prepareStatement("insert into users values(?,?,?)");//创建SQL语句
			ps.setString(1, userName);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.executeUpdate();
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
