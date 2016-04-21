package lab2.part3;

public class AccountFactory {

	public Account getAccountType(String accountNum){
		if(accountNum.charAt(0)=='i'||accountNum.charAt(0)=='I'||accountNum.charAt(0)=='c'||accountNum.charAt(0)=='C'){
			if(accountNum.charAt(0)=='I'||accountNum.charAt(0)=='i'){
				return new InvestmentAccount(accountNum);
			}
			else{
				return new CurrentAccount(accountNum);
			}
		}
		else{
			System.out.print("Invalid Selection");
			return null;
		}
	}
}
