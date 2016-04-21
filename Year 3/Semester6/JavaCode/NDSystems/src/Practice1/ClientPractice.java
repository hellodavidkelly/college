package Practice1;

import java.io.*;
import java.net.*;

public class ClientPractice extends Thread {

	DatagramSocket skt = null;
	FileEvent fileEvent = null;
	String fileName;
	String sourcePath = ("/Users/mjrbronchaus/Desktop/client/");
	String destinationPath = "/Users/mjrbronchaus/Desktop/server/";
	String hostname = "localhost";
	int serverPort;
    
	public ClientPractice(String fileName, int serverPort){
		this.fileName = fileName;
		this.serverPort = serverPort;
	}
	
	synchronized public void run(){
		client();
	}
	
	synchronized public void client(){
		try{
			sourcePath = sourcePath.concat(fileName);
			skt = new DatagramSocket(); //Instantiate the DatagramSocket
			InetAddress IPAddress = InetAddress.getByName(hostname); //Get IP address of Server 
			byte[] incomingData = new byte[65507]; //Create byte array to store incoming data
			fileEvent = getFileEvent();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(outputStream);
            os.writeObject(fileEvent);
            byte[] data = outputStream.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, serverPort);
            skt.send(sendPacket);
            System.out.println("File sent from client");
            DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
            skt.receive(incomingPacket);
            String response = new String(incomingPacket.getData());
            System.out.println("Response from server:" + response);
            skt.close();
            //System.exit(0);
			
		} catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	

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

}
