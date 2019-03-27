package spring.demo.demoui;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.demo.demodao.DemoDao;
import spring.demo.demoservice.DemoService;
/**
 * Spring入门，IOC原理
 * @author GaoYuan
 *
 */
public class Client {
	/**
	 * 
	 * 
	 * ClassPathXmlApplicationContext  只能加载类路径下的配置文件
	 * FileSystemXmlApplicationContext  可以加载磁盘路径下的任意配置文件
	 * 这两个类都是ApplicationContext的子类
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 
		 */
		// 1. 获取容器
		// ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		// 2. 通过id获取对象
		DemoService demoService = (DemoService) ac.getBean("demoService");
		DemoDao demoDao = (DemoDao) ac.getBean("demoDao");
		DemoDao demoDaoStatic = (DemoDao) ac.getBean("staticDemoDao");
		DemoDao demoDaoInstance = (DemoDao) ac.getBean("instanceDemoDao");
		System.out.println(demoService);
		System.out.println(demoDao);
		System.out.println(demoDaoStatic);
		System.out.println(demoDaoInstance);
		ac.close();
	}

}
