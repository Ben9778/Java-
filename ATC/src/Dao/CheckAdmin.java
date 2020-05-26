package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class CheckAdmin {
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	//验证管理员账户密码对错
	public boolean checkAdmin(String user,String password){
			String u=""; String p="";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=ATC","sa","123456");//连接数据库
			ps=ct.prepareStatement("select * from admins");//创建SQL语句
			rs=ps.executeQuery();
			if(rs.next()) {
				u=rs.getString(1);//用户名
				p=rs.getString(2);//密码
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
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
		if(u.equals(user)&&p.equals(password)) {
			return true;
		}else {
			return false;
		}	
	}
}

