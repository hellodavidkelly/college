package BookExample;

import java.io.IOException;
import java.net.*;

public class DatagramClient {

	public final static boolean fDebugOn = true;
	
	public final static int
		DEFAULT_MAX_DATAGRAM_SIZE = 512, //Max size of an incoming datagram
		DEFAULT_MAX_RETRIES = 10; //Number of times to resend if no response
	
	protected DatagramSocket fSocket; //This is where we send/receive data
	protected DatagramPacket fSendDatagram, fRecvDatagram;
	protected byte[] fSendBuffer, fRecvBuffer;
	protected int fSendBufLength, fRecvBufLength;
	protected int fSendPort, fRecvPort;
	protected InetAddress fRemoteAddress;
	protected int fRetryTimer = 5000, fRetryCount = 0;
	
	protected DatagramReplySlave fReplySlave;
	protected DatagramSendSlave fSendSlave;
	
	public DatagramClient(int inBufSize,
							byte[] outBuf,
							int localPort, int remotePort,
							InetAddress remoteAddress,
							int waitTime){
		fSendPort = remotePort;
		fRecvPort = localPort;
		fSendBufLength = outBuf.length;
		fRecvBufLength = ((inBufSize > 0) ? inBufSize: DEFAULT_MAX_DATAGRAM_SIZE);
		fRecvBuffer = new byte[fRecvBufLength];
		fRemoteAddress = remoteAddress;
		fRetryTimer = ((waitTime > 0) ? waitTime: fRetryTimer);
		fRecvDatagram = new DatagramPacket(fRecvBuffer, fRecvBufLength);
		fSendDatagram = new DatagramPacket(fSendBuffer, fSendBufLength, fRemoteAddress, fSendPort);	
	}
	
	//Constructor allows to instantiate without an output buffer
	public DatagramClient(int inBufSize,
							int localPort, int remotePort,
							InetAddress remoteAddress,
							int waitTime){
		fSendPort = remotePort;
		fRecvPort = localPort;
		fRecvBufLength = ((inBufSize > 0) ? inBufSize: DEFAULT_MAX_DATAGRAM_SIZE);
		fRecvBuffer = new byte[fRecvBufLength];
		fRemoteAddress = remoteAddress;
		fRetryTimer = ((waitTime > 0) ? waitTime: fRetryTimer);
		fRecvDatagram = new DatagramPacket(fRecvBuffer, fRecvBufLength);
		fSendDatagram = new DatagramPacket(fSendBuffer, fSendBufLength, fRemoteAddress, fSendPort);	
	}
	
	public void setOutputBuf(byte[] outBuf){
		fSendBuffer = outBuf;
		fSendBufLength = outBuf.length;
		fSendDatagram = new DatagramPacket(fSendBuffer, fSendBufLength,
										fRemoteAddress, fSendPort);
	}
	
	public DatagramPacket handleTransaction() throws SocketException, IOException{
		
		fRetryCount = 0;
		Bind();
		fSendSlave = new DatagramSendSlave(fRecvDatagram, fSocket, fRetryTimer);
		fReplySlave = new DatagramReplySlave(fRecvDatagram, fSocket, DEFAULT_MAX_RETRIES * fRetryTimer);
		
		fSendSlave.start();
		fReplySlave.start();
		
		int recvState = fReplySlave.waitOnReply(); //This blocks
		
		if(fDebugOn){
			System.out.println("DatagramClient recvState: " + recvState);
		}
		
		if(recvState != 1){
			fSendSlave.fSendState = 1; //Stop sender thread
		}
		
		if(fReplySlave.isAlive()){
			try{fReplySlave.stop();}
			catch(Throwable tex){}
		}
		
		return fRecvDatagram;
	}
	
	
	protected void Bind() throws SocketException{
		if(fRecvPort!=0){
			fSocket = new DatagramSocket(fRecvPort);
		}
		else{
			fSocket = new DatagramSocket();
		}
		
		if(fDebugOn){
			System.out.println("Bound to: " + fSocket.getLocalPort());
		}
	}
	
	public void Dispose(){
		if(fSocket!=null){
			fSocket.close();
		}
		fSendDatagram = null;
		fRecvDatagram = null;
	}
	
}
