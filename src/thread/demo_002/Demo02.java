package thread.demo_002;
/**
 * synchronized关键字
 * 对某个对象加锁
 * @author Jcon
 *
 */
public class Demo02 {

	private int count = 10;
	
	public void test(){
		synchronized (this) { //任何线程要执行下面的代码，必须先拿到Demo02对象实例的锁
			count --;
			System.out.println(Thread.currentThread().getName() + " count = " + count);
		}
	}
}
