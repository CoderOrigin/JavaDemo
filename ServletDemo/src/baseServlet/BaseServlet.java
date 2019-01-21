package baseServlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 利用反射实现，自定义参数method=函数名，然后就能调用子类中的自定义函数
		 */
		String methodName  = request.getParameter("method");
		
		if(methodName == null || methodName.isEmpty()) {
			throw new RuntimeException("您的路径中缺少method参数");
		}
		//获取当前类的Class对象
		Class<? extends BaseServlet> c = this.getClass();
		Method method = null;
		try {
			method = c.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
		}catch(Exception e) {
			throw new RuntimeException("没有找到您调用的method！");
		}
		
		try {
			System.out.println("before");
			method.invoke(this, request,response);
			System.out.println("after");
		}catch(Exception e) {
			throw new RuntimeException("您调用的方法内部出现了问题！");
		}
	}
}
