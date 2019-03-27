package spring.IOCdemo.userui;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.IOCdemo.userservice.impl.UserServiceImpl1;

public class Client {	
	/**
	 * 模拟用户页面，调用service层的函数，需要先获取容器
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//1. 获取容器
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		//2.获取bean
		UserServiceImpl1 us = (UserServiceImpl1) ac.getBean("userServiceImpl1");
		us.doFind();
		ac.close();
	}

}
