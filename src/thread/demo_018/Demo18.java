package thread.demo_018;
/**
 * 不要以字符串常量作为锁定的对象
 * 在下面的例子中，test1和test2其实锁定的是同一个对象
 * 这种情况还会发生比较诡异的现象，比如你用到了一个类库，在该类库中代码锁定了字符串"hello",
 * 但是你读不到源码，所以你在自己的代码中也锁定了"hello",这时候就有可能发生非常诡异的死锁阻塞，
 * 因为你的程序和你用的的类库不经意间使用了同一把锁
 * @author Jcon
 *
 */
public class Demo18 {

	String s1 = "hello";
	String s2 = "hello";
	
	public void test1(){
		synchronized (s1) {
			
		}
	}
	
	public void test2(){
		synchronized (s2) {
			
		}
	}
}
