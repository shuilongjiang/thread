package thread.demo_026;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池的概念
 * @author Jcon
 *
 */
public class T07_ParalleComputing {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long start = System.currentTimeMillis();
		List<Integer> results = getPrime(1, 200000);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		final int cupCoreNum = 4;
		
		ExecutorService service = Executors.newFixedThreadPool(cupCoreNum);
		
		MyTask myTask1 = new MyTask(1, 80000);
		MyTask myTask2 = new MyTask(80001, 130000);
		MyTask myTask3 = new MyTask(130001, 170000);
		MyTask myTask4 = new MyTask(170001, 200000);
		
		Future<List<Integer>> f1 = service.submit(myTask1);
		Future<List<Integer>> f2 = service.submit(myTask2);
		Future<List<Integer>> f3 = service.submit(myTask3);
		Future<List<Integer>> f4 = service.submit(myTask4);
		
		start = System.currentTimeMillis();
		f1.get();
		f2.get();
		f3.get();
		f4.get();
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
	}
	
	static class MyTask implements Callable<List<Integer>> {

		int startPos, endPos;
		
		public MyTask(int s, int e) {
			this.startPos = s;
			this.endPos = e;
		}
		@Override
		public List<Integer> call() throws Exception {
			List<Integer> r = getPrime(startPos, endPos);
			return r;
		}
	}
	
	static boolean isPrime(int num){
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	static List<Integer> getPrime(int start, int end){
		List<Integer> results = new ArrayList<Integer>();
		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				results.add(i);
			}
		}
		return results;
	}
	
}
