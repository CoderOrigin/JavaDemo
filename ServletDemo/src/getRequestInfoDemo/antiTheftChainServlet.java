package getRequestInfoDemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 演示防盗链功能
 */
@WebServlet("/antiTheftChainServlet")
public class antiTheftChainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String refer = request.getHeader("referer");
		
		if (refer == null || !refer.contains("localhost")) {
			response.getWriter().append("you are not from localhost");
			response.sendRedirect("http://www.baidu.com");
		}else {
			response.getWriter().append("you are from localhost");
		}
	}

}
