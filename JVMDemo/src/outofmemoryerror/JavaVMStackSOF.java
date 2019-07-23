package outofmemoryerror;

public class JavaVMStackSOF {
	private int stackLength = 1;
	
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length: " + oom.stackLength);
			throw e;
		}

	}
/*
输出：
stack length: 5787
Exception in thread "main" java.lang.StackOverflowError
eclipse新版的可能有限制，stack最小144k，按照书里设置128不行

另外，一直创建线程，也有可能导致stack溢出
*/
}
