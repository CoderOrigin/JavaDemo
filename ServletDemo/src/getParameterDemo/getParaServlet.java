package getParameterDemo;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getParaServlet
 */
@WebServlet("/getParaServlet")
public class getParaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//请求参数，需要在URL后加上 ?key1=value1&key2=value2
		Enumeration<String> names =  request.getParameterNames();
		while(names.hasMoreElements()) {
			String a = request.getParameter(names.nextElement());
			System.out.println(a);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//请求参数可以来自于URL后，也可以来自于表单
		Enumeration<String> names =  request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			String[] values = request.getParameterValues(name);
			System.out.println(name + " : " + Arrays.toString(values));
		}
		//用map获取,输出不好看，也可以再用上面的方法
		Map<String, String[]> map = request.getParameterMap();
		System.out.println(map);
		response.getWriter().append("I have got you information!");
	}

}
