package SuiTangProject;
/**
 * 军队线程
 * 模拟双方作战行为
 */
public class ArmyRunnable implements Runnable {
	// volatile变量保证可见性，其他线程可以对其进行修改。
	volatile boolean keepRunning = true;
	
	@Override
	public void run() {
		int count = 0;
		while (keepRunning) {
			//for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + "进攻第" + ++count + "次！");
			//}
			// 线程释放资源，重新竞争
			Thread.yield();
		}
		
		System.out.println(Thread.currentThread().getName() + "结束了攻击！");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
