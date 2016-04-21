package lab2.part3;

public class InvestmentAccount extends Account{

	String accountNum;
	
	InvestmentAccount(String accountNum){
		this.accountNum = accountNum;
	}
	
	public void display(){
		System.out.println("Investment Account num = " + accountNum); 
	}
}
