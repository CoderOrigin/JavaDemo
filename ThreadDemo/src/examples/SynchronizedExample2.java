package examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SynchronizedExample2 {
	// 修饰一个类，作用区域是该类的所有实例
	public void test1() {
		synchronized (SynchronizedExample2.class) {
			for (int j = 0; j < 10; j++) {
				System.out.printf("test1: %d\n", j);
			}
		}
	}
	
	// 修饰静态方法，此时作用区域也是该类的所有实例
	public static synchronized void test2() {
		for (int j = 0; j < 10; j++) {
			System.out.printf("test2: %d\n", j);
		}
	}
	public static void main(String[] args) {
		SynchronizedExample2 ex1 = new SynchronizedExample2();
		SynchronizedExample2 ex2 = new SynchronizedExample2();
		ExecutorService executorService = Executors.newCachedThreadPool(); 
		// 当调用ex1的两个方法时，无论同时要运行几次test1和test2，必须执行完上一次的test
		// 此时无论调用ex1和ex2的哪个方法 都不许执行完上一次
		executorService.execute(()-> {
			ex1.test1();
		});
		executorService.execute(()-> {
			ex2.test1();
		});
		
	}

}
