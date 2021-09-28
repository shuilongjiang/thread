package thread.demo_019;

import java.util.ArrayList;
import java.util.List;import java.util.concurrent.TimeUnit;


/**
 * 曾经的面试题：
 * 实现一个容器，提供两个方法，add,size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 * 
 * 分析下面这个程序，能完成这个功能吗？
 * @author Jcon
 *
 */
public class MyContainer2 {

	//添加volatile，使t2能够得到通知
	volatile List lists = new ArrayList();
	
	public void add(Object o){
		lists.add(o);
	}
	
	public int size(){
		return lists.size();
	}
	
	public static void main(String[] args) {
		MyContainer2 c = new MyContainer2();
		
		new Thread(()->{ //线程一
			for (int i = 0; i < 10; i++) {
				c.add(new Object());
				System.out.println("add " + i);
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}," t1").start();
		
		new Thread(()->{ //线程二
			while (true) {
				if (c.size() == 5) {
					break;
				}
			}
			System.out.println("t2线程结束");
		}, "t2").start();
	}
}
