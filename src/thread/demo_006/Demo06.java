package thread.demo_006;
/**
 * 对比上面一个小程序，分析一下这个程序的输出
 * @author Jcon
 *
 */
public class Demo06 implements Runnable{

	private int count = 10;

	@Override
	public synchronized void run() {
		count --;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}

	public static void main(String[] args) {
		
		for (int i = 0; i < 5; i++) {
			Demo06 demo06 = new Demo06();//注意这里
			new Thread(demo06,"THREAD" + i).start();
		}
	}
}
