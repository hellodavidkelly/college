package MyClient;

import java.io.*;
import java.net.*;
import java.nio.file.*;

public class MyClient {

	public static void main (String [] args){
		
		DatagramSocket skt;
		
		try{
			skt = new DatagramSocket(); //Create Datagram socket
			String msg = "Test Message "; //Create message
			Path file = Paths.get("timetable.pdf"); //Path to file
			//byte[] b = Files.readAllBytes(file); //Convert String message to bytes
			byte[] b = msg.getBytes();
			InetAddress host = InetAddress.getByName("localhost"); //Server name
			int serverSocket = 8080; //Port
			DatagramPacket request = new DatagramPacket(b,b.length,host,serverSocket); //Create packet
			skt.send(request); //Send packet
			
			//////////////////////////////////////////////////////////////////////////////////////
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			skt.receive(reply);
			System.out.print("Client received: " + new String(reply.getData()));
			skt.close();
		}catch(Exception Ex){
			
		}
	}
}
