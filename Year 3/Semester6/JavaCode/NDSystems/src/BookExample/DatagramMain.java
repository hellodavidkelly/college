package BookExample;

import java.net.*;
import java.io.*;
import java.util.*;

public class DatagramMain {

	public static void main (String [] args) throws IOException{
		
		byte[] buffer = new byte[65507];
		InetAddress clientAddress = InetAddress.getByName("127.0.0.1");

		DatagramClient client = new DatagramClient(buffer.length, buffer, 8080, 9000, clientAddress, 10000);
		DatagramServer server = new DatagramServer(8080, buffer.length);
		
		try {
			server.waitForRequest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.handleTransaction();
	}
}
