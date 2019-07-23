package examples;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicExample3 {
	
	public static AtomicReference<Integer> count = new AtomicReference<Integer>(0); 
	
	public static AtomicIntegerFieldUpdater<AtomicExample3> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample3.class, "count2");
	// 必须是valatile修饰，而且不能static修饰,还必须是int不是Integer
	public volatile int count2 = 100;
	
	public static void main(String[] args) {
		// 演示1
		count.compareAndSet(0, 1); // 0 -> 1
		count.compareAndSet(0, 2); // 不执行
		count.compareAndSet(1, 3); // 1 -> 3
		count.compareAndSet(2, 4); // 不执行
		count.compareAndSet(3, 5); // 3 -> 5
		System.out.println(count);
		
		// 演示2
		AtomicExample3 ex = new AtomicExample3();
		if (updater.compareAndSet(ex, 100, 120)) {
			System.out.println("success:"+ ex.count2);
		}
		if (updater.compareAndSet(ex, 100, 120)) {
			System.out.println("success:"+ ex.count2);
		} else {
			System.out.println("failed:"+ ex.count2);
		}
	}

}
