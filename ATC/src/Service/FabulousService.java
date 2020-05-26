package Service;

import Bean.Fabulous;
import Dao.Dao_Fabulous;

public class FabulousService {
		//该方法是用于添加点赞
		public void addFabulous(long bookID,String fabulous_ID,String byFabulous_ID) {
			Dao_Fabulous fabulous=new Dao_Fabulous();
			fabulous.Insert_Fabulous(bookID, fabulous_ID, byFabulous_ID);
		}
		//该方法是用于统计点赞数量
		public Fabulous fabulous_number(String byFabulous_ID) {
			Dao_Fabulous fabulous=new Dao_Fabulous();
			Fabulous number=fabulous.Fabulous_number(byFabulous_ID);
			return number;
		}
}
