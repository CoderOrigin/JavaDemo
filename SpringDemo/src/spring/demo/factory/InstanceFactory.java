package spring.demo.factory;

import spring.demo.demodao.DemoDao;
/**
 * 模拟一个实例工厂创建bean
 * @author GaoYuan
 *
 */
public class InstanceFactory {
	public DemoDao getDemoDao() {
		return new DemoDao();
	}
}
