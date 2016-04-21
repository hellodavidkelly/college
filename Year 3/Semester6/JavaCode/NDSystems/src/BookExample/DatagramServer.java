package BookExample;

import java.net.*;

public class DatagramServer {

	public final static int DEFAULT_MAX_DATAGRAM_SIZE = 512;
	protected DatagramSocket fRecvSocket; //Where receive and send data from
	protected DatagramPacket fRecvDatagram;
	protected byte[] fRecvBuffer;
	protected int fRecvBufSize;
	protected int fRecvPort;
	
	public DatagramServer(int port, int recvBufSize){
		fRecvPort = port;
		
		if(recvBufSize!=0){
			fRecvBufSize = recvBufSize; // Allows client to set buffer size
		}
		else{
			fRecvBufSize = DEFAULT_MAX_DATAGRAM_SIZE;
		}
	}
	
	public DatagramPacket waitForRequest() throws Exception{
		fRecvBuffer = new byte[fRecvBufSize];
		fRecvDatagram = new DatagramPacket(fRecvBuffer, fRecvBufSize);
		
		fRecvSocket.receive(fRecvDatagram); //Receive data into datagram
		return fRecvDatagram;
	}
	
	public void Bind() throws Exception{
		fRecvSocket = new DatagramSocket(fRecvPort); //Bind to local port
	}
	
	public void Dispose(){
		if(fRecvSocket!=null){
			fRecvSocket.close();
		}
	}
	
}
