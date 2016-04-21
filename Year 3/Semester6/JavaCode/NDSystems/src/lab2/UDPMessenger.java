package lab2;

import java.net.*;
import java.io.*;
import java.util.*;


public class UDPMessenger {

	static int clientPort = 9000;
	static int serverPort = 8080;
	
	public static void main(String [] args) throws IOException{
		DatagramSocket socket = new DatagramSocket();
		byte[] buffer = new byte[65507];
		InetAddress address = InetAddress.getByName("127.0.0.1");
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, serverPort);
		socket.send(packet);

		//Get port for sender and receiver
		//Can't be hard coded, must be user input
		Scanner keyboard = new Scanner(System.in);
		String userInput;
		System.out.println("Please enter initial system state (server / client):");
		userInput = keyboard.nextLine();
		System.out.println("Enter the sending port: ");
		serverPort = keyboard.nextInt();
		System.out.println("Enter the Receiving port: ");
		clientPort = keyboard.nextInt();
		do{
			if(userInput.equals("server")){
				System.out.println("Server Initialised");
				send();
				receive();
				send();
				receive();
				send();
				receive();
				send();
				break;
			}
			else if(userInput.equals("client")){
				System.out.println("Client Initialised");
				receive();
				send();
				receive();
				send();
				receive();
				send();
				receive();
				break;
			}
			else{
				System.out.println("Invalid selection: Please type server or client");
			}
		}while(!userInput.equals("server") || !userInput.equals("client"));
		//Get initial state of program, Send/Receive 
		socket.close();
	}
	
	public static void send() throws IOException{
		//Can not leave method until message is sent
		DatagramSocket datagramSocket = new DatagramSocket();
		Scanner keyboard = new Scanner(System.in);
		String str;
		do{
			System.out.println("Please enter message");
			str = keyboard.nextLine();
		}while(str.equals(""));

		byte[] buffer = str.getBytes();
		InetAddress receiverAddress = InetAddress.getLocalHost();
		
		DatagramPacket packet = new DatagramPacket(buffer,buffer.length,receiverAddress,serverPort);
		datagramSocket.send(packet);
		datagramSocket.close();
	}
	
	public static void receive() throws IOException{
		//Can not leave method until message is received
		DatagramSocket datagramSocket = new DatagramSocket(clientPort);
		byte[] buffer = new byte[65507];
		DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
		datagramSocket.receive(packet);
		buffer = packet.getData();
		String bufferP = new String(buffer);

		System.out.println("Received Messege: "+bufferP);
		datagramSocket.close();
	}
}
