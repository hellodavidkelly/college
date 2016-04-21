package Practice1;

import java.util.Scanner;

public class ClientTest {

    public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
    	System.out.print("Enter File name: ");
		String fileName = keyboard.nextLine();
    	System.out.print("Enter Server port number: ");
		int serverPort = keyboard.nextInt();
    	System.out.println("");
        ClientPractice client = new ClientPractice(fileName, serverPort);
        client.run();
    	System.out.println("-------------------------------------------------");
    	keyboard.close();
    }
}
