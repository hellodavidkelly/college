package moviedatabase;

import javax.swing.JOptionPane;

public class Member{
	
	Account acc = new Account();
	
	public void createAccount(String uName, String password, String email){

		acc.addAccount(uName, password, email);

	}
	
	public void removeAccount(String userName, String password){
		
		Boolean loggedIn = false;
		
		loggedIn = acc.login(userName, password);
		
		if(loggedIn){
			
			JOptionPane.showMessageDialog(null, "Got this far", "Yes", JOptionPane.INFORMATION_MESSAGE);
			acc.removeAccount(userName);
			
		}	
		
	}
	
	public void applyPermissions(){
		
		//If userId U1 give admin permissions else give normal permissions
		
	}
	
}