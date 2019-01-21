package visitorCountDemo;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EServlet
 */
@WebServlet("/EServlet")
public class EServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext application = this.getServletContext();
		Integer count = (Integer) application.getAttribute("count");
		if(count == null) {
			application.setAttribute("count", 1);
		}
		else {
			count++;
		}
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("访问次数： ").append(count.toString());
		application.setAttribute("count", count);
	}

}
