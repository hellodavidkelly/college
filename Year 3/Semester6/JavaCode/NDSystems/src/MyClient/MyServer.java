package MyClient;

import java.io.*;
import java.net.*;

public class MyServer {

	public static void main(String[] args) {

		DatagramSocket skt = null;
		
		try{
			skt = new DatagramSocket(8080);
			byte[] buffer = new byte [1000];
			
			while(true){
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				
				skt.receive(request);
				String[] arrayMsg = (new String(request.getData())).split(" ");
				byte[] sendMsg = (arrayMsg[1]+ " test server processed").getBytes();
				DatagramPacket reply = new DatagramPacket(sendMsg, sendMsg.length, request.getAddress(),request.getPort());
				
				skt.send(reply);
				
			}
		}catch(Exception Ex){
			
		}
	}

}
