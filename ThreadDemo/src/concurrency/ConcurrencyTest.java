package concurrency;

import java.util.concurrent.*;

public class ConcurrencyTest {
	// 模拟并发用户总量
	public static int clientTotal = 5000;
	// 同时能执行的并发数
	public static int threadTotal = 200;
	
	public static int count = 0;
			
	public static void main(String[] args) throws Exception {
		// 定义线程池
		ExecutorService executorService = Executors.newCachedThreadPool();
		// 模拟信号量
		final Semaphore semaphore = new Semaphore(threadTotal);
		// 定义计数, ？？？不是很理解
		final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		// 模拟请求
		for (int i = 0; i < clientTotal; i++) {
			executorService.execute(() -> {
				try {
					// 只有获得了线程执行权，才会进行执行
					semaphore.acquire();
					add();
					semaphore.release();
				} catch (Exception e) {
					e.printStackTrace();
				}
				countDownLatch.countDown();		
			});
		}
		countDownLatch.await();
		executorService.shutdown();
		System.out.println("count:" + count);// 此时返回的数字随机不确定的，线程不安全
	}
	
	public static void add() {
		count++;
	}

}
