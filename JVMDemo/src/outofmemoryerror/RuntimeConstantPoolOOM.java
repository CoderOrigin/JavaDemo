package outofmemoryerror;

import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		// 使用List保持常量池引用，避免Full GC回收常量池行为
		List<String> list = new ArrayList<String>();
		// 10MB 的PerSize 在integer范围内最够产生OOM
		int i = 0;
//		while (true) {
//			list.add(String.valueOf(i++).intern());
//		}

	}
/*
VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
Java8 已经移除了。。
Java HotSpot(TM) 64-Bit Server VM warning: Ignoring option PermSize; support was removed in 8.0
Java HotSpot(TM) 64-Bit Server VM warning: Ignoring option MaxPermSize; support was removed in 8.0

删除了参数之后：
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
常量池未填满之前，堆先满了？

实验失败！
 */
}
