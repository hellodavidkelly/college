package Ass1;

import java.util.Scanner;

public class TestAssServer {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
    	System.out.print("Enter Server port number: ");
		int port = keyboard.nextInt();
		AssServer sPractice = new AssServer(port);
    	System.out.println("Server running!..... waiting on client");
    	sPractice.run();
    	keyboard.close();	
    }
}
