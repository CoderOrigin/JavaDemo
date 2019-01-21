package lifePeriodDemo;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AServlet implements Servlet {

	/*
	 * Servlet生命周期函数只有三个带参数的：
	 * 1.init在第一次访问的时候执行，或者设置成启动服务器的时候执行
	 * 2.service在每次访问的时候执行，可以执行多次
	 * 3.destroy在服务器关闭的时候执行
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy..");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("getServletConfig..");
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("getServletInfo..");
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init...");

	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service..");

	}
}
