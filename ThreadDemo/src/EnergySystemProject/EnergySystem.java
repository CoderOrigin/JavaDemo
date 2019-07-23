package EnergySystemProject;

import java.util.Arrays;

/**
 * 模拟一个能量体系
 * @author GaoYuan
 *
 */
public class EnergySystem {
	private double[] energyBox;
	Object lockObj = new Object();
	
	// 初始化能量盒子大小，以及每个盒子的初始能量
	public EnergySystem(int n, double initialEnergy) {
		energyBox = new double[n];
		Arrays.fill(energyBox, initialEnergy);
	}
	
	public void transfer(int from, int to, double amount) {
		synchronized(lockObj) {
			while (energyBox[from] < amount) {
				try {
					lockObj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		//if (energyBox[from] < amount) return;
			energyBox[from] -= amount;
			System.out.printf("从%d号盒子转移出%f单位能量！", from, amount);
			System.out.print("正在转移。。。");
			energyBox[to] += amount;
			System.out.printf("将%f单位能量转移到了%d盒子！   ", amount, to);
			System.out.println("当前系统总能量：" + getTotalEnergy());
			lockObj.notifyAll();
		}
	}
	
	private double getTotalEnergy() {
		double sum = 0.0;
		for (double e: energyBox) {
			sum += e;
		}
		return sum;
	}
	
	public int getSize() {
		return energyBox.length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

}
