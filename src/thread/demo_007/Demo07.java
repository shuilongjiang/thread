package thread.demo_007;


/**
 * 同步方法和非同步方法是否可以同时调用？
 * @author Jcon
 *
 */
public class Demo07 {

	public synchronized void test1(){
		System.out.println(Thread.currentThread().getName() + " test1 start..........");
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " test1 end........");
	}
	
	public void test2(){
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "test2 execute......");
	}
	
	public static void main(String[] args) {
		Demo07 demo07 = new Demo07();
		
		new Thread(demo07 :: test1,"t1").start(); //JDK1.8新特性
		new Thread(demo07 :: test2,"t2").start(); //JDK1.8新特性
	}
}
