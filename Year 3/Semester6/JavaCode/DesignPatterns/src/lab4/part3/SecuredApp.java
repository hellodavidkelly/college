package lab4.part3;

import javax.swing.JFrame;

public class SecuredApp extends AppWelcome {

	public JFrame getGUI(String userType) {
		if(userType.equals("Returning User")){
			return new LoginFrame();
		}
		if(userType.equals("New User")){
			return new RegisterFrame();
		}
		return null;
	}

}
