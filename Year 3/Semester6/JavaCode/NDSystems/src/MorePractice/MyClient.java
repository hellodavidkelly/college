package MorePractice;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

public class MyClient {

	public void client() throws IOException{
		//Use scanner to receive user input for port numbers
		System.out.println("Enter Sending port number: ");
		Scanner keyboard = new Scanner(System.in);
		int portSender = keyboard.nextInt();		
		System.out.println("Enter Receiver port number: ");
		int portReceiver = keyboard.nextInt();
		
		//Create a datagram socket with port address
		DatagramSocket dSocket = new DatagramSocket(portSender);
		
		String hello = "Hello Server, I am Client";
		
		//Reference the file via nio api and path
		Path test = Paths.get("/Users/mjrbronchaus/Desktop/client/test.odt");
		
		//Create a new file class 
		File file = null;
		//Create a new File Input Stream and pass the file and source destination
		FileInputStream fis = new FileInputStream(file = new File("/Users/mjrbronchaus/Desktop/client/civ.srt"));
		
		//Create buffers for different formats of bye arrays
		//String byte[]
		byte[] strBuf = hello.getBytes();
		//Path byte[]
		byte[] pathBuf = Files.readAllBytes(test);
		//FileInputStream byte[]
		byte[] fileBuf = new byte[(int)file.length()];
		
		//Set the IP address of the RECEIVER/DESTINATION
		InetAddress ipReceiver = InetAddress.getByName("localhost");
		
		//Create Datagram packet to send on the socket	(/byte[] /byte[].length	/InetAddress	/int)
		DatagramPacket stringPacket = new DatagramPacket(strBuf, strBuf.length, ipReceiver, portReceiver);
		DatagramPacket pathPacket = new DatagramPacket(pathBuf, pathBuf.length, ipReceiver, portReceiver);
		DatagramPacket filePacket = new DatagramPacket(fileBuf, fileBuf.length, ipReceiver, portReceiver);
		
		//Pass DatagramPacket as parameter to sending socket
		dSocket.send(stringPacket);
		//dSocket.send(pathPacket);
		//dSocket.send(filePacket);
		
		//Close Datagram socket (house keeping)
		dSocket.close();		
	}
}
