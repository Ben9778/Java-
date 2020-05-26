package Web;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 import Service.*;

@WebServlet(name="UserRegistServlet" , urlPatterns="/userRegist" )
public class UserRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int number=0;
    public UserRegistServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//��ȡ�ͻ���ע�����Ϣ
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		//����service��
		RegistService registService=new RegistService();
		boolean checkUser=registService.check(userName);
		if(checkUser) {
			//�ѱ�ע������
			response.getWriter().write("<b>���û����ѱ�ע��!<b>");
		}else {
			//���û����
			registService.registUser(userName, password, email);
			response.getWriter().write("<b>��ϲ��ע��ɹ�,2�����ת����¼!<b>");
			response.setHeader("refresh","2,url='/ATC/login.jsp'");
		}
			
	}
}
