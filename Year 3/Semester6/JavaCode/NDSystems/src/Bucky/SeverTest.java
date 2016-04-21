package Bucky;

import javax.swing.*;

public class SeverTest {

		public static void main(String [] args){
			Server ServerObject = new Server();
			ServerObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			ServerObject.startRunning();
		}
}
