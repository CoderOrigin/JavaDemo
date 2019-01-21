package reDirectDemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class middleSerlvet
 */
@WebServlet("/middleSerlvet")
public class middleSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("middle.. ");
		
		//两部重定向
//		response.setHeader("Location", "/ServletDemo/terminalServlet");
//		response.setStatus(302);
		
		//快捷重定向
		response.sendRedirect("/ServletDemo/terminalServlet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
