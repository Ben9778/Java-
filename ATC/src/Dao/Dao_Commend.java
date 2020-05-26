package Dao;
import java.sql.*;

import Bean.Commend;
public class Dao_Commend {
	
	//添加评论内容
	public void Isert_Commend(long bookID,String commend_ID,String commend_content,String commend_time) {
		Connection ct=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=ATC","sa","123456");//连接数据库
			ps=ct.prepareStatement("insert into commend values(?,?,?,?)");//创建SQL语句
			ps.setLong(1, bookID);
			ps.setString(2, commend_ID);
			ps.setString(3, commend_content);
			ps.setString(4, commend_time);
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
	//查询评论内容
	public Commend selectCommend(long bookID) {
		Commend commend=null;
		Connection ct=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=ATC","sa","123456");//连接数据库
			ps=ct.prepareStatement("select * from commend where bookID=?");//创建SQL语句
			ps.setLong(1, bookID);
			rs=ps.executeQuery();
			if(rs.next()) {
				commend=new Commend();
				commend.setBookID(rs.getLong(1));
				commend.setCommend_ID(rs.getString(2));
				commend.setCommend_time(rs.getString(3));
				commend.setCommend_content(rs.getString(4));			
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
		return commend;
	}
}
