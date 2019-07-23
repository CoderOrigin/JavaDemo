package publish;
/**
 * 逃逸演示，在类发布（完成构造）之前，有些字段可以被发布出来，线程不安全，实际上是不行的
 * @author GaoYuan
 *
 */
public class Escape {
	
	private int thisCanEscape = 0;
	
	public Escape() {
		new innerClass();
		thisCanEscape = 1;
	}
	
	private class innerClass {
		public innerClass() {
			System.out.println(Escape.this.thisCanEscape);
		}
	}
	public static void main(String[] args) {
		Escape escape = new Escape();
	}

}
