package publish;

import java.util.Arrays;
/**
 * 不安全发布的演示，其他类或者其他线程很轻松修改私有变量，导致在使用时，并不知道是否被修改，线程不安全
 * @author GaoYuan
 *
 */
public class UnsafePublish {
	
	private String[] str = {"1", "2", "5"};
	
	public String[] getStr() {
		return str;
	}
	public static void main(String[] args) {
		UnsafePublish pub = new UnsafePublish();
		System.out.println(Arrays.toString(pub.getStr()));
		
		// 本来是私有属性的str，很轻松就被其他线程进行修改
		pub.getStr()[0] = "a";
		System.out.println(Arrays.toString(pub.getStr()));
	}

}
