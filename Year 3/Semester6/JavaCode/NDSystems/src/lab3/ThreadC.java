package lab3;

public class ThreadC extends Thread{

	public void run(){
		for(int x=0;x<5;x++){
			System.out.println("Tread C x:= "+x);
		}
		System.out.println("Thrad C ended!\n");
	}
}
