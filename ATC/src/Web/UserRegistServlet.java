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
		//获取客户端注册的信息
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		//调用service层
		RegistService registService=new RegistService();
		boolean checkUser=registService.check(userName);
		if(checkUser) {
			//已被注册提醒
			response.getWriter().write("<b>该用户名已被注册!<b>");
		}else {
			//新用户添加
			registService.registUser(userName, password, email);
			response.getWriter().write("<b>恭喜您注册成功,2秒后跳转至登录!<b>");
			response.setHeader("refresh","2,url='/ATC/login.jsp'");
		}
			
	}
}
