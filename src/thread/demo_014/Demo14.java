package thread.demo_014;

import java.util.ArrayList;
import java.util.List;

import thread.demo_013.Demo13;

/**
 * 对比上一个程序，可以用synchronized解决，synchronize可以保证可见性和原子性，volatile只能保证可见性
 * @author Jcon
 *
 */
public class Demo14 {

	int count = 0;
	
	public synchronized void test(){
		for (int i = 0; i < 10000; i++) {
			count ++;
		}
	}
	
	public static void main(String[] args) {
		Demo14 demo14 = new Demo14();
		
		List<Thread> threads = new ArrayList<Thread>();
		
		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(demo14::test, "thread-" + i));
		}
		
		threads.forEach((o)->o.start()); //JDK1.8新特性
		
		threads.forEach((o)->{ //JDK1.8新特性
			try {
				o.join(); //等线程执行完毕之后才执行主线程main
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		System.out.println(demo14.count);
	}
}
