package thread.demo_026;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;import java.util.concurrent.TimeUnit;


/**
 * 线程池的概念
 * @author Jcon
 *
 */
public class T05_ThreadPool {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(5); // 
		for (int i = 0; i < 6; i++) {
			service.execute(()->{
				try {
					TimeUnit.MICROSECONDS.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		}
		
		System.out.println(service);
		
		service.shutdown();
		System.out.println(service.isTerminated());
		System.out.println(service.isShutdown());
		System.out.println(service);
		
		TimeUnit.SECONDS.sleep(5);
		System.out.println(service.isTerminated());
		System.out.println(service.isShutdown());
		System.out.println(service);
	}
}
