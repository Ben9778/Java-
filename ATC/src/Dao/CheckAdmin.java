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
	//��֤����Ա�˻�����Դ�
	public boolean checkAdmin(String user,String password){
			String u=""; String p="";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=ATC","sa","123456");//�������ݿ�
			ps=ct.prepareStatement("select * from admins");//����SQL���
			rs=ps.executeQuery();
			if(rs.next()) {
				u=rs.getString(1);//�û���
				p=rs.getString(2);//����
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

