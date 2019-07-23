package examples;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
/**
 * 线程安全的，利用AtomicInteger
 * @author GaoYuan
 *
 */
public class AtomicExample2 {
	// 模拟并发用户总量
	public static int clientTotal = 5000;
	// 同时能执行的并发数
	public static int threadTotal = 20;
	// 这里使用AtomicLong与LongAdder对比
	public static AtomicLong count1 = new AtomicLong();
	// CAS操作会一直尝试，在竞争激烈的时候，会使得性能大大下降
	// LongAdder的优点是 分散了64位Long，每个部分都可以并行相加，最后汇总相加，在高并发的时候性能也很好
	// 缺点也有：有可能会产生计数出错。
	public static LongAdder count = new LongAdder(); 
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
		System.out.println("count:" + count);// 此时返回的数字确定，线程安全
	}
	
	public static void add() {
		count.increment();;;
	}

}
