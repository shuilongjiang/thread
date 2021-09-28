package thread.demo_022;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal线程局部变量
 * @author Jcon
 *
 */
public class ThreadLocal1 {

	volatile static Person p = new Person();
	
	public static void main(String[] args) {
		
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println(p.name);
		}).start();
		
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			p.name = "lisi";
		}).start();
	}
}

class Person{
	String name = "zhangsan";
}