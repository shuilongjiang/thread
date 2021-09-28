package thread.demo_015;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 解决同样的问题的更高效的方法，使用AtomXXX类
 * AtomXXX类本身方法都是原子性的，但不能保证多个方法连续调用是原子性
 * @author Jcon
 *
 */
public class Demo15 {

	//int count = 0;
	AtomicInteger count = new AtomicInteger(0);
	
	public /*synchronized*/ void test(){
		for (int i = 0; i < 10000; i++) {
			//count ++;
			count.incrementAndGet(); //count++
		}
	}
	
	public static void main(String[] args) {
		Demo15 demo15 = new Demo15();
		
		List<Thread> threads = new ArrayList<Thread>();
		
		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(demo15::test, "thread-" + i));
		}
		
		threads.forEach((o)->o.start()); //JDK1.8新特性
		
		threads.forEach((o)->{ //JDK1.8新特性
			try {
				o.join(); //等线程执行完毕之后才执行主线程main
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		System.out.println(demo15.count);
	}


}
