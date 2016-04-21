package Client;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame	{
	
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = "";
	private String serverIP;
	private Socket connection;
	
	//Constructor
	public Client(String host){
		super("Client");
		serverIP = host;
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						sendMessage(event.getActionCommand());
						userText.setText("");
					}
				}
		);
		add(userText, BorderLayout.SOUTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow), BorderLayout.CENTER);
		setSize(420,220);
		setVisible(true);
		setResizable(false);
		setLocation(0,300);
		chatWindow.setForeground(Color.GREEN);
		chatWindow.setBackground(Color.DARK_GRAY);
		chatWindow.setEditable(false);
	}
	
	//Connect to server
	public void startRunning(){
		try{
			connectToServer();
			setupStreams();
			whileChatting();
		}catch(EOFException	eofException){
			showMessage("\nClient terminated connection");
		}catch(IOException	ioException){
			ioException.printStackTrace();
		}finally{
			closeConnection();
		}
	}
	
	//Connect to server
	private void connectToServer() throws IOException{
		showMessage("Attempting to connect...\n");
		connection = new Socket(InetAddress.getByName(serverIP), 8080);
		showMessage("Connected to " + connection.getInetAddress().getHostName() + "\n");
	}
	
	//Setup streams to send and receive
	private void setupStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n - Streams are now connected! \n");
	}
	
	//While chatting with server
	private void whileChatting() throws IOException{
		ableToType(true);
		do{
			try{
				message = (String) input.readObject();
				showMessage("\n" + message);
			}catch(ClassNotFoundException	classNotFoundException){
				showMessage("\n I dont know that object type");
			}
		}while(!message.equals("SERVER: END"));
	}
	
	//Closing down stream and sockets
	private void closeConnection(){
		showMessage("\nConnection terminated\n");
		ableToType(false);
		try{
			output.close();
			input.close();
			connection.close();
		}catch(IOException	ioException){
			ioException.printStackTrace();
		}
	}
	
	//Send message to server
	private void sendMessage(String message){
		try{
			output.writeObject("CLIENT: " + message);
			output.flush();
			showMessage("\nCLIENT: " + message);
		}catch(IOException	ioException){
			chatWindow.append("\n Error sending message");
		}
	}
	
	//Update chat window
	private void showMessage(final String m){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						chatWindow.append(m);
					}
				}
		);
	}
	
	//Allow user to type in box
	private void ableToType(final boolean tof){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						userText.setEditable(tof);
					}
				}
		);
	}
	
}
