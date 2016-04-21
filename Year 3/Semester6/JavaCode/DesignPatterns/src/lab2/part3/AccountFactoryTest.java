package lab2.part3;

public class AccountFactoryTest {

	public static void main(String[] args) {
		String acc1 = new String("C10001");
		String acc2 = new String("C10002");
		String acc3 = new String("I20001");
		String acc4 = new String("I20002");
		
		AccountFactory aFactory = new AccountFactory();

		aFactory.getAccountType(acc4);
		aFactory.getAccountType(acc2);
		aFactory.getAccountType(acc3);
		aFactory.getAccountType(acc1);
		
		aFactory.getAccountType(acc4).display();
		aFactory.getAccountType(acc3).display();
		aFactory.getAccountType(acc2).display();
		aFactory.getAccountType(acc1).display();
	}

}
