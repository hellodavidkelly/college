package Ass12;

import java.io.*;
import java.net.*;
import java.util.*;

import Practice1.FileEvent;

public class AssClient extends Thread{

	DatagramSocket skt = null;
	FileEvent fileEvent = null;
	String fileName;
	String sourcePath = ("/Users/mjrbronchaus/Desktop/client/");
	String destinationPath = "/Users/mjrbronchaus/Desktop/server/";
	String hostname = "localhost";
	int serverPort;
	int transferCount = 0;
	int data = 50;
	
	public AssClient(String fileName, int serverPort){
		this.fileName = fileName;
		this.serverPort = serverPort;
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void run(){
		client();
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void client(){
		try{
			sourcePath = sourcePath.concat(fileName);
			skt = new DatagramSocket(); //Instantiate the DatagramSocket
			InetAddress IPAddress = InetAddress.getByName(hostname); //Get IP address of Server 
			byte[] buf = new byte[100000000]; //Create byte array
			List<byte[]> array = divideArray(buf, 50000);
			fileEvent = getFileEvent();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(outputStream);
            os.writeObject(fileEvent);
            
            //////////////////////////////////////////////////////////////////////////////////Send Packet
            for(int i=1;i<array.size();i++){
                DatagramPacket sendPacket = new DatagramPacket(array.get(i), array.get(i).length, IPAddress, serverPort);
                skt.send(sendPacket);
                transferCount++;
                if(transferCount==9){
                	System.out.println(data+"mb Transferred");
                	transferCount=0;
                	data = data+50;
                }
            }
            
            System.out.println("File sent from client");
            byte[] incomingData = new byte[65500];
            DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
            skt.receive(incomingPacket);
            String response = new String(incomingPacket.getData());
            System.out.println("Response from server:" + response);
            skt.close();
            
		} catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////
	public FileEvent getFileEvent() {
        FileEvent fileEvent = new FileEvent();
        String fileName = sourcePath.substring(sourcePath.lastIndexOf("/") + 1, sourcePath.length());
        fileEvent.setDestinationDirectory(destinationPath);
        fileEvent.setFilename(fileName);
        fileEvent.setSourceDirectory(sourcePath);
        File file = new File(sourcePath);
        
        if (file.isFile()) {
            try {
                DataInputStream diStream = new DataInputStream(new FileInputStream(file));
                long len = (int) file.length();
                byte[] fileBytes = new byte[(int) len];
                int read = 0;
                int numRead = 0;
                while (read < fileBytes.length && (numRead = diStream.read(fileBytes, read,
                        fileBytes.length - read)) >= 0) {
                    read = read + numRead;
                	System.out.println(numRead+"kb of transfer complete");
                }
                fileEvent.setFileSize(len);
                fileEvent.setFileData(fileBytes);
                fileEvent.setStatus("Success");
            } catch (Exception e) {
                e.printStackTrace();
                fileEvent.setStatus("error");
            }
        } else {
            System.out.println("path specified is not pointing to a file");
            fileEvent.setStatus("Error");
        }
        return fileEvent;
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
