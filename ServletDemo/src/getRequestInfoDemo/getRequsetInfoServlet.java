package getRequestInfoDemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取请求客户的信息
 */
@WebServlet("/getRequsetInfoServlet")
public class getRequsetInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  这个是request信息，header中的 key和value 要区分参数
		String info = request.getHeader("user-agent");
		 info += ("ip: " +request.getRemoteAddr());
		response.getWriter().append(info);
		
	}

}
