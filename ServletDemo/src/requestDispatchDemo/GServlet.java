package requestDispatchDemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GServlet
 */
@WebServlet("/GServlet")
public class GServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("GServlet...");
		//测试留头不留体,如果要response的数据过大，会留下一些
		response.setHeader("AAA", "aaa");
		response.getWriter().print("GGGGGGGG");
		RequestDispatcher rd =  request.getRequestDispatcher("/HServlet");
		rd.forward(request, response);
	}

}
