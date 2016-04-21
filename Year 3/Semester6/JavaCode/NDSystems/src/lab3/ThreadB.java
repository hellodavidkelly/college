package lab3;

public class ThreadB extends Thread{

	public void run(){
		for(int j=0;j<5;j++){
			System.out.println("Tread B j:= "+j);
		}
		System.out.println("Thread B ended!\n");
	}
}
