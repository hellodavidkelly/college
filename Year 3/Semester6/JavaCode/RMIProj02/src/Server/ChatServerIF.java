package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Client.ChatClientIF;

public interface ChatServerIF extends Remote {
	//Method to add client to vector
	void registerChatClient(ChatClientIF client) throws RemoteException;
	//Method to send message to all clients
	void broadcastMessage(String message) throws RemoteException;
}
