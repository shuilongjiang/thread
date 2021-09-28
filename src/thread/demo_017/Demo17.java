package thread.demo_017;

import java.util.concurrent.TimeUnit;

import org.omg.CORBA.TIMEOUT;

/**
 * 锁定某对象o，如果o的属性发生改变，不影响锁的使用
 * 但是如果o变成另外一个对象，则锁定的对象发生改变
 * 应该避免将锁定对象的引用变成另外一个对象
 * @author Jcon
 *
 */
public class Demo17 {

	Object o = new Object();
	
	public void test(){
		synchronized (o) {
			while (true) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
				
			}
		}
	}
	
	public static void main(String[] args) {
		Demo17 demo17 = new Demo17();
		//启动第一个线程
		new Thread(demo17 :: test, "t1").start(); //JDK1.8新特性
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//启动第二个线程
		Thread t2 = new Thread(demo17 :: test, "t2");
		
		demo17.o = new Object(); //所对象发生改变，所以t2线程得以执行，如果注释掉这句话，线程t2将永远得不到执行机会
		
		t2.start();
	}
}
