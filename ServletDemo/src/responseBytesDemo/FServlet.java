package responseBytesDemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 响应字节流demo
 */
@WebServlet("/FServlet")
public class FServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = "Hello world!";
		byte[] bytes = s.getBytes();
		response.getOutputStream().write(bytes);
		
	}

}
