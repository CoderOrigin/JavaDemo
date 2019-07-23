package SuiTangProject;

public class KeyPersonThread extends Thread {
	
	public KeyPersonThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "开始战斗！");
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "非常勇猛！杀了" + i + "个敌人！");
		}
		System.out.println(Thread.currentThread().getName() + "结束了战斗！");
	}
	
	
}
