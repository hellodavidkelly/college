package lab2.part3;

public abstract class Account {

	protected String currentAccount;
	protected String investmentAccount;
	
	Account(){
		currentAccount = null;
		investmentAccount = null;
	}
	
	public String getCurrent(){
		return currentAccount;
	}
	
	public String getInvestment(){
		return investmentAccount;
	}
	
	public void display(){
		
	}
	
}
