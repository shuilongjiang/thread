package thread.demo_013;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile并不能保证多个线程共同修改running变量时所带来的不一致问题，
 * 也就是说volatile不能替代synchronize
 * 运行下面的程序，并分析结果
 * @author Jcon
 *
 */
public class Demo13 {

	volatile int count = 0;
	
	public void test(){
		for (int i = 0; i < 10000; i++) {
			count ++;
		}
	}
	
	public static void main(String[] args) {
		Demo13 demo13 = new Demo13();
		
		List<Thread> threads = new ArrayList<Thread>();
		
		for (int i = 0; i < 10; i++) {
			threads.add(new Thread(demo13::test, "thread-" + i));
		}
		
		threads.forEach((o)->o.start()); //JDK1.8新特性
		
		threads.forEach((o)->{ //JDK1.8新特性
			try {
				o.join(); //等线程执行完毕之后才执行主线程main
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		System.out.println(demo13.count);
	}
}
