package Bucky;

import java.io.*;
import java.net.*;
import java.util.Calendar;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Server extends JFrame	{
	
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	
	//constructor
	Server(){
		
		super("Server");
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
		add(userText,BorderLayout.SOUTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow));
		setSize(420,220);
		setVisible(true);
		setResizable(false);
		setLocation(0,0);
		chatWindow.setForeground(Color.ORANGE);
		chatWindow.setBackground(Color.DARK_GRAY);
		chatWindow.setEditable(false);
	}
	
	
	//Setup and run server
	public void startRunning(){
		try{
			server = new ServerSocket(8080,10);
			while(true){
				try{
					//connect and have conversation
					waitForConnection();
					setupStreams();
					whileChatting();
				}catch(EOFException eofException){
					showMessage("\nServer ended connection\n");
				}finally{
					closeConnection();
				}
			}
		}catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	//Wait for connection
	private void waitForConnection() throws IOException{
		showMessage("Waiting for somoeone to connect...\n");
		connection = server.accept();
		showMessage("Now connected to " +connection.getInetAddress().getHostName() + "\n");

	}
	
	//Setup the streams to send and receive data
	private void setupStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n - Streams are now connected! \n");
	}
	
	//While chatting during chat conversation
	public void whileChatting() throws IOException{
		String message = "Connection made @: " + Calendar.getInstance().getTime();
		sendMessage(message);
		ableToType(true);
		do{
			try{
				message = (String) input.readObject();
				showMessage("\n" + message);
			}catch(ClassNotFoundException classNotFoundException){
				showMessage("\n oops!");
			}
		}while(!message.equals("CLIENT: END"));
	}
	
	//Close all streams and sockets after use
	private void closeConnection(){
		showMessage("\nClient ended connection\n");
		ableToType(false);
		try{
			output.close();
			input.close();
			connection.close();
		}catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	//Send a message to client 
	private void sendMessage(String message){
		try{
			output.writeObject("SERVER: " + message);
			output.flush();
			showMessage("\nSERVER: " + message);
		}catch(IOException ioException){
			chatWindow.append("Cant send!");
		}
	}
	
	//Show chat window
	private void showMessage(final String text){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						chatWindow.append(text);
					}
				}
		);
	}
	
	//Let user type into box
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
