package thread.demo_025;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class T09_Synchronized {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> strings = new SynchronousQueue<String>();
		
		new Thread(()->{
			try {
				System.out.println(strings.take());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
		
		strings.put("aaa"); //阻塞等待消费者消费
		//strings.add("aaa");
		System.out.println(strings.size());
	}
}
