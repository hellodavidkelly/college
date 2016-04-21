package lab3;

public class AccountTest {

	public static void main(String[] args) {
		Account a = new Account();
		Thread me = new Thread(new MyAccountThread(a));
		Thread you = new Thread(new YourAccountThread(a));
		Thread her = new Thread(new HerAccountThread(a));
				
		me.start();
		you.start();
		her.start();
	}

}
