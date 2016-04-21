package lab3;

public class ThreadExample3 {

	public static void main(String[] args){
		Thread a = new ThreadA();
		Thread b = new ThreadB();
		Thread c = new ThreadC();
		
		c.setPriority(Thread.MAX_PRIORITY);
		b.setPriority(1);
		a.setPriority(1);
		
		
		a.start();
		b.start();
		c.start();
	}

}
