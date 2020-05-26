package ServerAdmin;
import java.util.*;
import java.sql.*;
import Gonggong.*;
public class YanZheng {
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	public YanZheng(User u) throws Exception {		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载驱动
		ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DataBaseName=ChatService","sa","123456");//连接数据库
		ps=ct.prepareStatement("select * from AdminUsers");//创建SQL语句
		rs=ps.executeQuery();
		if(rs.next()){
			int a=rs.getInt(1);
			String aa=rs.getString(2);
			System.out.print(a+"   "+aa);
		}else {
			System.out.println("表格是空的");
		}
	}
}
