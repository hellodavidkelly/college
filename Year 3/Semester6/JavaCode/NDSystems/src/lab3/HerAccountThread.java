package lab3;


public class HerAccountThread implements Runnable{
	Account account;
	
	public HerAccountThread(Account s){
		account = s;
	}
	
	public void run(){
		account.enquire();
	}
}