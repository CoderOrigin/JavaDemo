package EnergySystemProject;


public class EnergyTransferTest {

	final static int NUM = 10;
	final static double INITIAL_ENERGY = 1000.0;
	
	
	public static void main(String[] args) {
		// 创建初始能量体系
		EnergySystem system = new EnergySystem(NUM, INITIAL_ENERGY);
		for (int i = 0; i < system.getSize(); i++) {
			EnergyTransferTask task = new EnergyTransferTask(system, i, INITIAL_ENERGY);
			Thread t = new Thread(task, "Thread_" + i);
			t.start();
		}

	}

}
