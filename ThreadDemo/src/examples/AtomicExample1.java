package examples;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * 线程安全的，利用AtomicInteger
 * @author GaoYuan
 *
 */
public class AtomicExample1 {
	// 模拟并发用户总量
	public static int clientTotal = 5000;
	// 同时能执行的并发数
	public static int threadTotal = 20;
	
	public static AtomicInteger count = new AtomicInteger();
			
	public static void main(String[] args) throws Exception {
		// 定义线程池
		ExecutorService executorService = Executors.newCachedThreadPool();
		// 模拟信号量
		final Semaphore semaphore = new Semaphore(threadTotal);
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
		System.out.println("count:" + count.get());// 此时返回的数字确定的，线程安全
	}
	
	public static void add() {
		count.incrementAndGet();
	}

}
