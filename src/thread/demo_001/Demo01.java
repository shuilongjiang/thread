package thread.demo_001;
/**
 * synchronized关键字
 * 对某个对象加锁
 * @author Jcon
 *
 */
public class Demo01 {

	private int count = 10;
	private Object object = new Object();
	
	public void test(){
		synchronized (object) { //任何线程要执行下面的代码，必须先拿到object对象的锁
			count --;
			System.out.println(Thread.currentThread().getName() + " count = " + count);
		}
	}
}
