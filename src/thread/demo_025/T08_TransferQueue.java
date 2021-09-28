package thread.demo_025;

import java.util.concurrent.LinkedTransferQueue;

public class T08_TransferQueue {

	public static void main(String[] args) throws InterruptedException {
		LinkedTransferQueue<String> strings = new LinkedTransferQueue<String>();
		
		/*new Thread(()->{
			try {
				System.out.println(strings.take());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();*/
		
		//strings.transfer("aaa");
		
		strings.put("aaa");
		
		new Thread(()->{
			try {
				System.out.println(strings.take());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}
}
