package Dao;
import java.sql.*;
public class UpdateAdmin {
	Connection ct=null;
	PreparedStatement ps=null;
	private static String admin; 
	//修改管理员密码
	public UpdateAdmin(String newPassword){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=ATC","sa","123456");
			ps=ct.prepareStatement("Update admins set password=? where admin=?");//创建SQL语句
			ps.setString(1, newPassword);
			ps.setString(2, admin);
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
