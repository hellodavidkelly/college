package Ass12;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssServer extends Thread {
	
	DatagramSocket skt = null;
	DatagramPacket pkt = null;
	FileEvent fileEvent = null;
	int port;
	
	public AssServer(int port){
		this.port = port;
	}
	
	public void run(){
		server();
	}
	
	public void server(){
		while(true){
			try{
				skt = new DatagramSocket(port); //Create new datagram socket
				byte[] buf = new byte[100000000]; //Create byte array
				List<byte[]> array = divideArray(buf, 50000); //Create new byte array of max size
				String merge = new String();
System.out.println("here");
				for(int i=0;i<=10000;i++){
					do{
						//Create new datagram packet (byte[] memory address, byte[].length(65507))
						pkt = new DatagramPacket(array.get(i), array.get(i).length);
						System.out.println(pkt.toString()+"hrr");
						skt.receive(pkt); //Instance of DatagramSocket to receive packet from any remote server
						System.out.println(pkt.toString());
						byte[] buffer = array.get(i);
						buffer = pkt.getData(); //Set data inside byte[] buffer to == the DatagramPacket received from remote server
						//Store the buffer data as stream to read from byte[0] -> byte [last]
						ByteArrayInputStream byteStream = new ByteArrayInputStream(buffer, 0 , buffer.length);
						merge.equals(byteStream);
						System.out.println(merge);
						//Reads object from byte stream
						ObjectInputStream objectStream = new ObjectInputStream(byteStream);
						//Getting information from object stream
						fileEvent = (FileEvent) objectStream.readObject();
					}while(pkt!=null);
					break;
				}

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
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static List<byte[]> divideArray(byte[] source, int chunksize) {
		
		List<byte[]> result = new ArrayList<byte[]>();
		int start = 0;
		while (start < source.length) {
		int end = Math.min(source.length, start + chunksize);
		result.add(Arrays.copyOfRange(source, start, end));
		start += chunksize;
		}
		
		return result;
	}	
}
