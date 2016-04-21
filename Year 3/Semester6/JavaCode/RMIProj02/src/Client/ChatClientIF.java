package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatClientIF extends Remote{
	//Method for the broadcast method in ChatServer to update all clients
	void retreiveMessages(String message) throws RemoteException;
}
