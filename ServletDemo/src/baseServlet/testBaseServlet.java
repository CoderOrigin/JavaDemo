package baseServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/testBaseServlet")
public class testBaseServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public void fun1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("fun1()...");
	}
}
