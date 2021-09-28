package thread.demo_005;
/**
 * 分析一下这个程序的输出
 * @author Jcon
 *
 */
public class Demo05 implements Runnable{

	private int count = 10;
	
	@Override
	public /*synchronized*/ void run(){
		count --;
		System.out.println(Thread.currentThread().getName() + " count = " + count);
	}
	
	public static void main(String[] args) {
		Demo05 demo05 = new Demo05();
		for (int i = 0; i < 5; i++) {
			new Thread(demo05,"THREAD" + i).start();
		}
	}
}
