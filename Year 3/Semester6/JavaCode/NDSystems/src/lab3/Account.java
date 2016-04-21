package lab3;

public class Account {

	int balance;
	
	public synchronized void deposit(){
		balance += 10;
		System.out.print(balance + "\n");
	}
	
	public synchronized void withdraw(){
		balance -= 5;
		System.out.print(balance + "\n");
	}
	
	public synchronized void enquire(){
		System.out.print(balance + "\n");
	}
}
