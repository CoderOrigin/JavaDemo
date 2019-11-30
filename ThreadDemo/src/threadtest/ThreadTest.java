package threadtest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantLock;

import concurrency.ConcurrencyTest;

public class ThreadTest extends Thread{
	
	public void run() {
		System.out.println("bbb");
	}
	
	public static void main(String[] args) throws Exception {

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
		return;
			}
		}, new Date());
		ReentrantLock lock = new ReentrantLock();
		// Runnable r = new ThreadTest();
		Thread r1 = new ThreadTest();
		Thread r2 = new ThreadTest();
		r1.start();
		System.out.println("aaa");
		r2.start();
		System.out.println("ccc");
//		输出顺序：
//		aaa
//		bbb
//		ccc
//		bbb
		
		// 反射
		Class c = ThreadTest.class;
		Class<?> clazz = Class.forName("concurrency.ConcurrencyTest");
		ThreadTest tt = (ThreadTest) c.getDeclaredConstructor().newInstance();
		ConcurrencyTest ct = (ConcurrencyTest) clazz.getDeclaredConstructor().newInstance();
		Field f1 = clazz.getDeclaredField("count");
		Method m1 = clazz.getDeclaredMethod("add", null);
		f1.set(null, 1);
		System.out.println(ConcurrencyTest.count); 
		m1.invoke(null, null);
		System.out.println(ConcurrencyTest.count);
	}
}
