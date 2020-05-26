package Tools;
import java.sql.*;
import java.util.*;
public class CheckUser {
	private String u;//用户名
	private String p;//密码
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	//构造函数
	public boolean Check(String user,String password) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=school","sa","123456");//连接数据库
			ps=ct.prepareStatement("select * from users");//查询数据库
			rs=ps.executeQuery();
			if(rs.next()) {
				u=rs.getString(1);//获取数据库表里的用户名
				p=rs.getString(2);//获取数据库表里的密码
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
