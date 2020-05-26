package Web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Bean.Commend;
import Service.CommendService;

@WebServlet(name="CommendServlet",urlPatterns="/commend")
public class CommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommendServlet() {
		super();	
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ѯ����
		long bookID=Long.parseLong(request.getParameter("bookID"));
		CommendService commendservice=new CommendService();
		Commend commend=null;
		commend=commendservice.selectCommend(bookID);
		String ID=commend.getCommend_ID();
		String content=commend.getCommend_content();
		String time=commend.getCommend_time();
		if(ID!=null&&content!=null&&time!=null) {
			request.setAttribute("ID", ID);
			request.setAttribute("content", content);
			request.setAttribute("time", time);
		}else {
			request.setAttribute("empty", "������ɳ��");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//�������
		long bookID=Long.parseLong(request.getParameter("bookID"));
		String commend_ID=request.getParameter("commend_ID");
		String commend_content=request.getParameter("commend_content");
		String commend_time=request.getParameter("commend_time");
		CommendService commendservice=new CommendService();
		commendservice.addCommend(bookID, commend_ID, commend_content,commend_time);
	}

}
