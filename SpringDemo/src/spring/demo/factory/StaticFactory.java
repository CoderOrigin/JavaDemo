package spring.demo.factory;

import spring.demo.demodao.DemoDao;

/**
 * 模拟一个静态工厂
 * @author GaoYuan
 *
 */
public class StaticFactory {
	
	public static DemoDao getDemoDao() {
		return new DemoDao();
	}
}
