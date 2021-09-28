package thread.demo_003;
/**
 * synchronized关键字
 * 对某个对象加锁
 * @author Jcon
 *
 */
public class Demo03 {

	private int count = 10;
	
	public synchronized void test(){//等同于synchronized(this)，锁定的是Demo03对象的实例
		count --;
		System.out.println(Thread.currentThread().getName() + " count =" + count);
	}
}
