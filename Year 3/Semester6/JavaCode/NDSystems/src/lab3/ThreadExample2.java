package lab3;

public class ThreadExample2 {

	public static void main(String[] args) {
		Thread t = new Thread(new MyThread());
		t.start();
	}

}
