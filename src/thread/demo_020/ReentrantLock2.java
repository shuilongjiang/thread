package thread.demo_020;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantlock用于替代synchronized
 * 本例中由于test1锁定this，只有test1执行完毕的时候,test2才能执行
 * 这里是复习synchronized最原始的语义
 * 
 * 使用reentrantlock可以完成同样的功能
 * 需要注意的是，必须要必须要必须要手动释放锁（重要的事情说三遍）
 * 使用syn锁定的话如果遇到异常，jvm会自动释放锁，但是lock必须手动释放锁，因此经常在finally中进行锁的释放
 * @author Jcon
 *
 */
public class ReentrantLock2 {

	Lock lock = new ReentrantLock();
	
	public void test1(){
		try {
			lock.lock(); //synchronized(this)
			for (int i = 0; i < 10; i++) {
			System.out.println(i);
			
			TimeUnit.SECONDS.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally { //必须手动释放
			lock.unlock();
		}
	}
	
	public void test2(){
		lock.lock();
		System.out.println("execute test2........");
		lock.unlock();
	}
	
	public static void main(String[] args) {
		ReentrantLock2 rl = new ReentrantLock2();
		new Thread(rl::test1).start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(rl::test2).start();
	}
}
