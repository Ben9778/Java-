package Web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.User;
import Service.LoginService;

import java.util.*;

@WebServlet(name="UserLogin",urlPatterns="/userlogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UserLoginServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		//获取客户端发送的登陆账户信息
		String user=request.getParameter("userName");
		String password=request.getParameter("password");
		LoginService loginService=new LoginService();
		User users=new User();
		users=loginService.login(user, password);
		if(users!=null) {
			request.getSession().setAttribute("welcome", "欢迎您"+user);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else {
			request.setAttribute("ErrorMessage", "账号或密码有误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
