package Assignment1;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.file.*;
import java.util.*;

import Assignement1Ex.FileEvent;

public class SplitArray {
	
	FileEvent event = null;
    private String sourceFilePath = "/Users/mjrbronchaus/Desktop/College/Semester6/JavaCode/NDSystems/src/Assignement1Ex/test.odt";
    private String destinationPath = "/Users/mjrbronchaus/Desktop/test/";
    
	public static void main (String [] args) throws IOException{
		SplitArray split = new SplitArray();
		split.file();
	}
	
	public void file() throws IOException{
		try{
			String path = ("/Users/mjrbonchaus/Desktop/client/david_kelly.pdf");
			//path.concat(fileName);
			Path file = Paths.get(path);
			
			DatagramSocket dSocket = new DatagramSocket(8000);
	        InetAddress IPAddress = InetAddress.getByName("localhost");
	
			byte[] buf = new byte[100000000];
			
			List<byte[]> array = divideArray(buf, 50000);
			event = getFileEvent();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(outputStream);
            os.writeObject(event);
            byte[] data = outputStream.toByteArray();
            System.out.print(array.size());
            for(int i=0;i<(array.size()-1);i++){
            DatagramPacket sendPacket = new DatagramPacket(array.get(i), array.get(i).length, IPAddress, 8080);
            dSocket.send(sendPacket);
            }
            System.out.println("File sent from client");
            DatagramPacket incomingPacket = new DatagramPacket(buf, buf.length);
            dSocket.receive(incomingPacket);
            String response = new String(incomingPacket.getData());
            System.out.println("Response from server: " + response);
            Thread.sleep(2000);
            System.exit(0);
			
		} catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public FileEvent getFileEvent() {
        FileEvent fileEvent = new FileEvent();
        String fileName = sourceFilePath.substring(sourceFilePath.lastIndexOf("/") + 1, sourceFilePath.length());
        String path = sourceFilePath.substring(0, sourceFilePath.lastIndexOf("/") + 1);
        fileEvent.setDestinationDirectory(destinationPath);
        fileEvent.setFilename(fileName);
        fileEvent.setSourceDirectory(sourceFilePath);
        File file = new File(sourceFilePath);
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
                }
                fileEvent.setFileSize(len);
                fileEvent.setFileData(fileBytes);
                fileEvent.setStatus("Success");
            } catch (Exception e) {
                e.printStackTrace();
                fileEvent.setStatus("Error");
            }
        } else {
            System.out.println("path specified is not pointing to a file");
            fileEvent.setStatus("Error");
        }
        return fileEvent;
    }
	
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
