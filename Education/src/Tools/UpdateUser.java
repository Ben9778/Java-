package Tools;
import java.sql.*;
import java.util.*;
public class UpdateUser {
	private String u;//�û���
	private String p;//����
	Connection ct=null;
	PreparedStatement ps=null;
	//��װu��p
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
	//���캯���޸��˺�����
	public UpdateUser() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=school","sa","123456");//�������ݿ�
			ps=ct.prepareStatement("update Users set userID=?,password=? where userID='admin'and password='admin'");//�޸����ݿ�
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
