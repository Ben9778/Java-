package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import Bean.Fabulous;

public class Dao_Fabulous {
	//������������
	public void Insert_Fabulous(long bookID,String fabulous_ID,String byFabulous_ID){
		Connection ct=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=ATC","sa","123456");//�������ݿ�
			ps=ct.prepareStatement("insert into fabulous values(?,?,?)");//����SQL���
			ps.setLong(1, bookID);
			ps.setString(2, fabulous_ID);
			ps.setString(3, byFabulous_ID);
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
	//��ѯ���޵�����
	public Fabulous Fabulous_number(String byFabulous_ID) {
		Connection ct=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Fabulous fabulous=null;
		List<Fabulous>number=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=ATC","sa","123456");//�������ݿ�
			ps=ct.prepareStatement("select Fabulous_ID(*) from fabulous where byFabulous_ID=?");//����SQL���
			ps.setString(1, byFabulous_ID);
			rs=ps.executeQuery();
			if(rs.next()) {
				fabulous=new Fabulous();
				number=new ArrayList<Fabulous>();
//				fabulous.setBookID(rs.getLong(1));
				fabulous.setFabulous_ID(rs.getString(2));
//				fabulous.setbyFabulous_ID(rs.getString(3));
				number.add(fabulous);
				fabulous.setStatistics(number.size());
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
		return fabulous;
	}	
}

