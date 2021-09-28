package thread.demo_022;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal线程局部变量
 * 
 *  * ThreadLocal是使用空间换时间，synchronized是使用时间换空间
 * 比如在hibernate中session就存在与ThreadLocal中，避免synchronized的使用
 *
 * 运行下面的程序，理解ThreadLocal
 * ThreadLocal只对当前线程范围有效。
 * @author Jcon
 *
 */
public class ThreadLocal2 {

	/*volatile static Person p = new Person();*/
	private static ThreadLocal<Person1> tl = new ThreadLocal<>();
	
	public static void main(String[] args) {
		
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println(tl.get());
		}).start();
		
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			tl.set(new Person1());
		}).start();
	}
}

class Person1 {
	String name = "zhangsan";
}