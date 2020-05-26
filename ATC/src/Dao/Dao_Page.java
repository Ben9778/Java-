package Dao;
import java.sql.*;

import Bean.Commend;
public class Dao_Page {
	public void selectPage() {
		Connection ct=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int totalPage=0;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=ATC","sa","123456");//连接数据库
			ps=ct.prepareStatement("select top 10commend_ID from commend");//创建SQL语句
			rs=ps.executeQuery();
			if(rs.next()) {
				totalPage=rs.getRow();
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
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
