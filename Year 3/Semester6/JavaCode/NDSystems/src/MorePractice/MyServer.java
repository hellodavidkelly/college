package MorePractice;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;

public class MyServer {

	public void server() throws IOException{
		while(true){
			//Create new Datagram socket
			DatagramSocket dSocket = new DatagramSocket();
			
			//Create byte[] to store bytes from Sender packet
			byte[] buffer = new byte[65500];
			
			//Create Datagram packet to store received message(byte[] /byte[].length)
			DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);
			
			//Set buffer to equal the data received in the packet from the sender
			buffer = receivedPacket.getData();
			
			//Change received byte[] back to string
			String stringBuffer = buffer.toString();
			String strBuffer = new String(buffer);
			
			//Store the buffer data as stream to read from byte[0] -> byte [last]
			ByteArrayInputStream byteStream = new ByteArrayInputStream(buffer, 0 , buffer.length);
			//Convert ByteArrayInputStream to String
			String outArray = byteStream.toString();
	
			/*
			//Reads object from byte stream
			ObjectInputStream objectStream = new ObjectInputStream(byteStream);
			
			File transferredFile = new File("/Users/mjrbronchaus/Desktop/server/(Transferd)File");
			FileOutputStream fos = new FileOutputStream(transferredFile);
			
			int data; 
			while((data=objectStream.read())!=-1){ 
				char ch = (char)data;
				fos.write(ch);
			}
			
			fos.flush();
			fos.close();
			*/
			
			System.out.println("Message Received: "+outArray);
			
			if(outArray.equalsIgnoreCase("exit")){
				System.exit(0);
			}
		}
	}
}
