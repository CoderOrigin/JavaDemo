package SuiTangProject;

public class Stage extends Thread {
	
	@Override
	public void run() {
		System.out.println("大戏开始！隋朝末年、、");
		// 创建双方军队
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable armyTaskOfArmyOfRevolt = new ArmyRunnable();
		Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty, "隋军");
		Thread armyOfRevolt = new Thread(armyTaskOfArmyOfRevolt, "农民起义军");
		
		// 启动军队，开始打仗
		armyOfSuiDynasty.start();
		armyOfRevolt.start();
		
		// 让舞台线程进行休眠，打仗开始进行
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("双方你来我往，半路杀出了一个程咬金");
		
		// 创建程咬金角色
		Thread yaojinCheng = new KeyPersonThread("程咬金");
		System.out.println("旁白：程咬金希望终止战争");
		
		armyTaskOfArmyOfRevolt.keepRunning = false;
		armyTaskOfSuiDynasty.keepRunning = false;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 程咬金登场
		yaojinCheng.start();
		
		// 如果不调用join，会先执行 ”结束“代码
		// join方法会使其他线程等待该线程执行，并结束，才会执行其他进程
		try {
			yaojinCheng.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("战争结束，演出结束！");
	}

	public static void main(String[] args) {
		new Stage().start();
	}

}
