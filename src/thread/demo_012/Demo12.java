package thread.demo_012;

import java.util.concurrent.TimeUnit;

/**
 * volatile 关键字，是一个变量在多个线程间可见
 * @author Jcon
 *
 */
public class Demo12 {

	volatile boolean running = true;
	
	public void test(){
		System.out.println("test start.......");
		while (running) {
			/*try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
		}
		System.out.println("test end........");
	}
	
	public static void main(String[] args) {
		Demo12 demo12 = new Demo12();
		
		new Thread(demo12 :: test, "t1").start(); //JDK1.8新特性
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		demo12.running = false;
	}
}
