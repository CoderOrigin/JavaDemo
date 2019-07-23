package outofmemoryerror;

import java.lang.reflect.Field;

import sun.misc.Unsafe;


/*
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * 
 * 越过DirectByteBuffer类，用反射获取实例并分配内存
 * 用DirectByteBuffer进行分配内存也会抛出内存溢出异常，但是实际上并未真正向系统申请内存，
 * 而是通过计算得知。
 * 真正申请分配内存的方法：unsafe.allocateMemory()
 * 
 * 实验失败！？？？？
 */
public class DirectMemoryOOM {
	
	private static final int _1MB = 1024*1024;
	public static void main(String[] args) throws Exception {
		// 获取Unsafe类的字段
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);
		while (true) {
			// 真正分配内存的方法
			unsafe.allocateMemory(_1MB);
		}
	}

}
