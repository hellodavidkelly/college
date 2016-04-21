package BookExample;

import java.io.IOException;
import java.net.*;

public class DatagramSendSlave extends Thread{
	
	protected final static boolean fDebugOn = true;
	
	DatagramPacket fSendPacket;
	DatagramSocket fSendSocket;
	public int fSendState = 0; //Neither received nor failed
	protected int fRetryInterval; //In msec
	
	public DatagramSendSlave(DatagramPacket sendPacket,
								DatagramSocket sendSocket,
								int retryTime){
		fSendPacket = sendPacket;
		fSendSocket = sendSocket;
		fRetryInterval = retryTime;
	}
	
	public void run(){
		if(fDebugOn){
			System.out.println("DatagramSendSlave running....");
		}
		while(fSendState == 0){
			try{
				if(fDebugOn){
					System.out.println("DatagramSendSlave sending....");
				}
				fSendSocket.send(fSendPacket);
				fSendState = 0; //Sent ok
				
				if(fDebugOn){
					System.out.println("DatagramSendSlave sent ok!");
				}
				
				try{this.sleep(fRetryInterval);}
				catch(InterruptedException iEx){
					if(fDebugOn){
						System.out.println("DatagramSendSlave sleep interrupted!");
					}
					fSendState = -1;
				}
			}catch(IOException sendEx){
				if(fDebugOn){
					System.out.println("Send failed! " + sendEx);
				}
			}
		}
	}

}
