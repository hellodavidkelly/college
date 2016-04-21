package lab3;

public class MyAccountThread implements Runnable{
	Account account;
	
	public MyAccountThread(Account s){
		account = s;
	}
	
	public void run(){
		account.deposit();
	}
}
