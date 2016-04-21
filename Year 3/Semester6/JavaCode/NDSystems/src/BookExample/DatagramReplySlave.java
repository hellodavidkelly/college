package BookExample;

import java.io.IOException;
import java.net.*;

public class DatagramReplySlave extends Thread {
	
	private final static boolean fDebugOn = true;
	
	DatagramPacket fRecvPacket;
	DatagramSocket fRecvSocket;
	DatagramClient fParent;
	int fWaitTime = 50000;
	
	public int fReceivedState = 0;
	
	public DatagramReplySlave(DatagramPacket recvPacket,
								DatagramSocket recvSocket,
								int totalWaitTime){
		fRecvPacket = recvPacket;
		fRecvSocket = recvSocket;
		fWaitTime = totalWaitTime;
	}
	
	public synchronized int waitOnReply(){
		try{wait(fWaitTime);}
		catch(InterruptedException intEx){
			if(fDebugOn){
				System.out.println("waitOnReply Interrupt!");
			}
		}
		return fReceivedState;
	} //Wait on reply

	public synchronized void run(){
		if(fDebugOn){
			System.out.println("DatagramReplySlave running....");
		}
		
		try{
			if(fDebugOn){
				System.out.println("DatagramReplySlave Receiving....");
			}
			fRecvSocket.receive(fRecvPacket);
			fReceivedState =1; //Received ok
			System.out.println("DatagramReplySlave received ok!");
		}catch(IOException receiveEx){
			System.err.println("receive failed!" + receiveEx);
			fReceivedState = -1;
		} //Receive failed
		notify();
	}
	
}
