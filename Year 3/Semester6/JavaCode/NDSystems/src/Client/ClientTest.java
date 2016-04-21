package Client;

import javax.swing.*;

public class ClientTest {

	public static void main(String [] args){
		Client ClientObject;
		ClientObject = new Client("127.0.0.1");
		ClientObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ClientObject.startRunning();
	}
}
