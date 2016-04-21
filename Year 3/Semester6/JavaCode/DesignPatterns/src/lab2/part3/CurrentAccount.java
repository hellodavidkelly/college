package lab2.part3;

public class CurrentAccount extends Account{

	String accountNum;
	
	CurrentAccount(String accountNum){
		this.accountNum = accountNum;
	}
	
	public void display(){
		System.out.println("Current Account num = " + accountNum); 
	}
}
