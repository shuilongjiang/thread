package thread.demo_025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 写时复制容器 copy on write
 * 多线程环境下，写时效率低，读时效率高
 * 适合写少读多的环境
 * @author Jcon
 *
 */
public class T02_CopyOnWriteList {

	public static void main(String[] args) {
		List<String> lists = 
				//new ArrayList<String>(); //这个会出并发问题
				//new Vector<String>();
				new CopyOnWriteArrayList<String>();
		Random r = new Random();
		Thread[] threads = new Thread[100];
		
		for (int i = 0; i < threads.length; i++) {
			Runnable task = new Runnable() {
				
				@Override
				public void run() {
					for (int j = 0; j < 1000; j++) {
						lists.add("a" + r.nextInt(10000));
					}
				}
			};
			threads[i] = new Thread(task);
		}
		
		runAndComputeTime(threads);
		
		System.out.println(lists.size());
	}

	private static void runAndComputeTime(Thread[] threads) {
		long start = System.currentTimeMillis();
		Arrays.asList(threads).forEach(t->t.start());
		Arrays.asList(threads).forEach(t->{
			try {
				t.join(); //join等线程执行完之后再往下执行
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
