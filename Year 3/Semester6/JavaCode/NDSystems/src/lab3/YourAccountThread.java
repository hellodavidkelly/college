package lab3;

public class YourAccountThread implements Runnable{
	Account account;
	
	public YourAccountThread(Account s){
		account = s;
	}
	
	public void run(){
		account.withdraw();
	}
}