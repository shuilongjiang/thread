package thread.demo_025;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class T05_LinkedBlockingQueue {

	private static BlockingQueue<String> strings = new LinkedBlockingQueue<String>();
	private static Random r = new Random();
	
	public static void main(String[] args) {
		new Thread(()->{
			for (int i = 0; i < 100; i++) {
				try {
					strings.put("a" + i); //如果满了，就会等待
					TimeUnit.SECONDS.sleep(r.nextInt(10));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "p1").start();
		
		for (int i = 0; i < 5; i++) {
			new Thread(()->{
				for(;;){
					try {
						System.out.println(Thread.currentThread().getName() + "take -" + strings.take()); //如果空了，就会等待
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
			},"c" + i).start();
		}
	}
}
