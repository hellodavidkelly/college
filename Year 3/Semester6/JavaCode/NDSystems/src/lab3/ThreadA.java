package lab3;

public class ThreadA extends Thread{

	public void run(){
		for(int i=0;i<5;i++){
			System.out.println("Tread A i:= "+i);
		}
		System.out.println("Thread A ended!\n");
	}
}
