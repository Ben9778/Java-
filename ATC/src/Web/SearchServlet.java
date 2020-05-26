package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import netscape.javascript.JSObject;
import sun.net.www.http.HttpClient;

@WebServlet(name="SearchServlet",urlPatterns="/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<String>list=new ArrayList<String>();
   static{
   		list.add("ajax");
   	 	list.add("Json");
   	 	list.add("C语言");
   	 	list.add("Java");
   	 	list.add("Python");
   	 	list.add("Go");
   	 	list.add("Ruby");
   	}
   
    public SearchServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text=request.getParameter("search");
		List<String>list2=getDate(text);
		//转换成JSON格式
		JSONArray json=JSONArray.fromObject(list2);
		response.getWriter().write(json.toString());
	}
	public List<String>getDate(String text){
		List<String>list1=new ArrayList<String>();
		for(String ss:list) {
			if(ss.contains(text)) {
				list1.add(ss);
			}
		}
		return list1;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
