package Ass12;

import java.util.Scanner;

public class TestAssServer {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
    	System.out.print("Enter Client port number: ");
		int port = keyboard.nextInt();
		AssServer server = new AssServer(port);
    	System.out.println("Server running!..... waiting on client");
    	server.run();
    	keyboard.close();	
    }
}
