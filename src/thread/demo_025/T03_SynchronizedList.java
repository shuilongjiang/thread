package thread.demo_025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T03_SynchronizedList {

	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		List<String> synchronizedList = Collections.synchronizedList(arrayList); //此时的集合是同步的
		
	}
}
