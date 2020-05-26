package Dao;
import java.sql.*;

import Bean.Commend;
public class Dao_Commend {
	
	//�����������
	public void Isert_Commend(long bookID,String commend_ID,String commend_content,String commend_time) {
		Connection ct=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=ATC","sa","123456");//�������ݿ�
			ps=ct.prepareStatement("insert into commend values(?,?,?,?)");//����SQL���
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
	//��ѯ��������
	public Commend selectCommend(long bookID) {
		Commend commend=null;
		Connection ct=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=ATC","sa","123456");//�������ݿ�
			ps=ct.prepareStatement("select * from commend where bookID=?");//����SQL���
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
