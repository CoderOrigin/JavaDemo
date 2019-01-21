package initChildServletDemo;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class childServlet extends fatherServlet {
	
	/*
	 * 视频里讲的也可以，但是不需要重新写一个init函数，可以在init里面把父类的init函数先执行一次即可
	 */
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//		super.init(config);
//	}
	/*
	 * 视频里讲得方法
	 */
	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("child Servlet is born!");
	}
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String value = super.getInitParameter("n1");
		System.out.println(value);
	}
	
}
