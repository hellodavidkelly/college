package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Client.ChatClientIF;

public class ChatServer extends UnicastRemoteObject implements ChatServerIF {

	private static final long serialVersionUID = 1L;
	//Vector of all clients 
	private ArrayList<ChatClientIF> chatClients;
	
	//Contstrucor instantiate the Client vector
	protected ChatServer() throws RemoteException {
		chatClients = new ArrayList<ChatClientIF>();
	}

	//Add a new Chat Client to the vector
	public synchronized void registerChatClient(ChatClientIF chatClient) throws RemoteException {
		this.chatClients.add(chatClient);
	}

	//Use the Chat Client vector to send latest message to all clients
	public synchronized void broadcastMessage(String message) throws RemoteException {
 		int i=0;
 		while(i<chatClients.size()){
 			chatClients.get(i++).retreiveMessages(message);
 		}
	}

}
