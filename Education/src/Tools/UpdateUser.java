package Tools;
import java.sql.*;
import java.util.*;
public class UpdateUser {
	private String u;//用户名
	private String p;//密码
	Connection ct=null;
	PreparedStatement ps=null;
	//封装u和p
	public String getU() {
		return u;
	}

	public void setU(String u) {
		this.u = u;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}
	//构造函数修改账号密码
	public UpdateUser() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=school","sa","123456");//连接数据库
			ps=ct.prepareStatement("update Users set userID=?,password=? where userID='admin'and password='admin'");//修改数据库
			ps.setString(1, this.getU());
			ps.setString(2, this.getP());
			ps.executeUpdate();
		} catch (Exception e) {}
		finally {
			try {
				if(ct!=null) {
					ct.close();
				}
				if(ps!=null) {
					ps.close();
				}
			}catch (Exception e1) {}
		}
	}
}
