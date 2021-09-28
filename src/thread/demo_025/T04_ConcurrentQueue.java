package thread.demo_025;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class T04_ConcurrentQueue {

	public static void main(String[] args) {
		Queue<String> strings = new ConcurrentLinkedQueue<String>();
		
		for (int i = 0; i < 10; i++) {
			strings.offer("a" + i); //相当于add， 放进队列
		}
		
		System.out.println(strings);
		
		System.out.println(strings.size());
		
		System.out.println(strings.poll()); //取出并移除掉
		System.out.println(strings.size());
		
		System.out.println(strings.peek()); //取出，不会移除。相当于get(0)
		System.out.println(strings.size());
	}
}
