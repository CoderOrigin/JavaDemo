package EnergySystemProject;

public class EnergyTransferTask implements Runnable {
	
	// 体系的能量
	EnergySystem system;
	// 转移的fromBox
	int fromBox;
	// 能转移的最大能量值
	double maxAmount;
	// 每次转移后的休眠时间
	final int DELAY = 10;
	
	public EnergyTransferTask(EnergySystem system, int fromBox, double maxAmount) {
		super();
		this.system = system;
		this.fromBox = fromBox;
		this.maxAmount = maxAmount;
	}

	@Override
	public void run() {
		while (true) {
			int toBox = (int) (system.getSize() * Math.random());
			double amount = Math.random() * maxAmount;
			system.transfer(fromBox, toBox, amount);
			//Thread.sleep((int) (Math.random() * DELAY));
			//Thread.yield();
		}
	}

}
