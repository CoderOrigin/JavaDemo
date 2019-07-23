package examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample1 {
	// 修饰{}代码块，作用区域是调用的对象
	public void test1() {
		synchronized (this) {
			for (int j = 0; j < 10; j++) {
				System.out.printf("test1: %d\n", j);
			}
		}
	}
	
	// 修饰方法，作用区域也是调用的对象
	public synchronized void test2() {
		for (int j = 0; j < 10; j++) {
			System.out.printf("test2: %d\n", j);
		}
	}
	public static void main(String[] args) {
		SynchronizedExample1 ex1 = new SynchronizedExample1();
		SynchronizedExample1 ex2 = new SynchronizedExample1();
		ExecutorService executorService = Executors.newCachedThreadPool(); 
		// 当调用ex1的两个方法时，无论同时要运行几次test1和test2，必须执行完上一次的test
		// 而分别调用ex1和ex2中的test方法时，交替进行
		executorService.execute(()-> {
			ex1.test1();
		});
		executorService.execute(()-> {
			ex2.test1();
		});
		
		
	}

}
