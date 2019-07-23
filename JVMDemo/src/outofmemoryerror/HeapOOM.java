package outofmemoryerror;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
	
	static class OOMObject {
		
	}
	
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		
		while (true) {
			list.add(new OOMObject());
		}

	}
/*
java.lang.OutOfMemoryError: Java heap space
[0.598s][info][gc] GC(10) Concurrent Cycle 156.228ms
Dumping heap to java_pid23383.hprof ...
Heap dump file created [28265405 bytes in 0.293 secs]
*/
}
