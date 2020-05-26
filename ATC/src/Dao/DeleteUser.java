package Dao;

import java.sql.*;
public class DeleteUser {
	Connection ct=null;
	PreparedStatement ps=null;
	//注销账户
	public DeleteUser(String user){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载数据库驱动
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=User","sa","123456");//连接数据库
			ps=ct.prepareStatement("delete from users where name=?");
			ps.setString(1,user);
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
