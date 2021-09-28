package thread.demo_004;
/**
 * synchronized关键字
 * 对某个对象加锁
 * @author Jcon
 *
 */
public class Demo04 {

	private static int count = 10;
	
	public synchronized static void test1(){ //这里等同于synchronized(Demo04.class)
		count --;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}
	
	public static void test2(){ //考虑一下这里写synchronize(this)是否可以
		synchronized (Demo04.class) {
			count --;
		}
	}
}
