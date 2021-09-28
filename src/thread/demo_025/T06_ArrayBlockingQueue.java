package thread.demo_025;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class T06_ArrayBlockingQueue {

	private static BlockingQueue<String> strings = new ArrayBlockingQueue<String>(10);
	
	private static Random r = new Random();
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			strings.put("a" + i);
		}
		
		//strings.put("aaaa"); //满了就会等待，程序阻塞
		//strings.add("aaaa");
		//strings.offer("aaaa");
		strings.offer("aaaa", 1, TimeUnit.SECONDS);
		
		System.out.println(strings);
	}
}
