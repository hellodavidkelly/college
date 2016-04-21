package Practice1;

import java.io.*;
import java.net.*;

public class ServerPractice extends Thread {
	
	DatagramSocket skt = null;
	FileEvent fileEvent = null;
	int port;
	
	public ServerPractice(int port){
		this.port = port;
	}
	
	public void run(){
		server();
	}
	
	public void server(){
		while(true){
			try{
				skt = new DatagramSocket(port); //Create new datagram socket
				byte[] buffer = new byte[65507]; //Create new byte array of max size
				
				//Create new datagram packet (byte[] memory address, byte[].length(65507))
				DatagramPacket pkt = new DatagramPacket(buffer, buffer.length);
				
				skt.receive(pkt); //Instance of DatagramSocket to receive packet from any remote server
				
				buffer = pkt.getData(); //Set data inside byte[] buffer to == the DatagramPacket received from remote server
				//Store the buffer data as stream to read from byte[0] -> byte [last]
				ByteArrayInputStream byteStream = new ByteArrayInputStream(buffer, 0 , buffer.length);
				//Reads object from byte stream
				ObjectInputStream objectStream = new ObjectInputStream(byteStream);
				//Getting information from object stream
				fileEvent = (FileEvent) objectStream.readObject();
				//Exit program if file event can't read object stream
				if(fileEvent.getStatus().equalsIgnoreCase("error")){
					System.out.println("Error occurd on client side while reading object file \nProgram Exiting!");
					System.exit(0);
				}
				
				//Method to reassemble the file from information gathered in ObjectInputStream and save it to HD
				createTransferredFile(); 
				
				//////////////////////////////////////SEND REPLY TO CLIENT//////////////////////////////////////////////
				////////////////////////////////////WHERE STATS GET SENT BACK///////////////////////////////////////////
				
				InetAddress clientAddress = pkt.getAddress(); //Get Clients Address from received packet data
				int clientPort = pkt.getPort(); //Get Clients port from received packet data
				String reply = (" File Transfer Complete / " + fileEvent.getStatus()); //Message sent back to Client
				byte[] replyBytes = reply.getBytes(); //Convert String in to byte array
				//Reply Datagram packet to be sent to client
				DatagramPacket replyPacket = new DatagramPacket(replyBytes, replyBytes.length, clientAddress, clientPort);
				skt.send(replyPacket); //Sending packet back from server socket to client
				skt.close();
				//System.exit(0);
			} catch (SocketException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
		}
	}
	
	public void createTransferredFile(){
		String outputFile = (fileEvent.getDestinationDirectory() + "(Transferred)" + fileEvent.getFilename());
		
		/*if (!new File(fileEvent.getDestinationDirectory()).exists()) {
            new File(fileEvent.getDestinationDirectory()).mkdirs();
        }*/
		
		File destinationFile = new File(outputFile);
		FileOutputStream fileOutputStream = null;
		try{
			fileOutputStream = new FileOutputStream(destinationFile);
            fileOutputStream.write(fileEvent.getFileData());
            fileOutputStream.flush();
            fileOutputStream.close();
            System.out.println("Output file : " + outputFile + " is successfully saved ");
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
}
