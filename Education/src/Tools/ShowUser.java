package Tools;
import java.sql.*;
import java.util.*;
public class ShowUser {
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	private String u;
	private String p;
	//封装变量u和p
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
	//构造函数
	public ShowUser() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=school","sa","123456");//连接数据库
			ps=ct.prepareStatement("select * from users");//修改数据库
			rs=ps.executeQuery();//显示结果
			while(rs.next()) {
				this.setU(rs.getString(1));
				this.setP(rs.getString(2));
			}
		} catch (Exception e) {
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

	}
}
