package ServerAdmin;
import java.util.*;
import java.sql.*;
import Gonggong.*;
public class YanZheng {
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	public YanZheng(User u) throws Exception {		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//��������
		ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=ChatService","sa","123456");//�������ݿ�
		ps=ct.prepareStatement("select * from AdminUsers");//����SQL���
		rs=ps.executeQuery();
		if(rs.next()){
			int a=rs.getInt(1);
			String aa=rs.getString(2);
			System.out.print(a+"   "+aa);
		}else {
			System.out.println("����ǿյ�");
		}
	}
}
