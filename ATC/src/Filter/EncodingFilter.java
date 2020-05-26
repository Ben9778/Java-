package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


@WebFilter(
		filterName="encodingFilter",
		urlPatterns = "/*", 
		initParams = { 
				@WebInitParam(name = "ContentType", value = "text/html;charset=utf-8")
		})
public class EncodingFilter implements Filter {

	private String encoding;
    public EncodingFilter() {
    
    }

	
	public void destroy() {
		encoding=null;
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(encoding!=null) {
			response.setContentType(encoding);
		}
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		encoding=fConfig.getInitParameter("ContentType");
	}

}
