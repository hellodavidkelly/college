package moviedatabase;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import javax.swing.JOptionPane;

public class DatabaseEngine{
	
	Connection connection;
	String url;
	String userName;
	String password;
	String databaseName;
	
	public DatabaseEngine(String userName, String password){
		
		connection = null;
		this.userName = userName;
		this.password = password;
		
	}
	
	public Connection connect(){
		
		InputStream inputStr = getClass().getResourceAsStream("DatabaseEngine.properties");
	    Properties prop = new Properties();
	    
	    try{
	    	
	    	prop.load(inputStr);
	    	url = prop.getProperty("connectionURL");
	    	databaseName = prop.getProperty("databaseName");
	    	
	    }
	    catch (IOException e){
	    	
	    	JOptionPane.showMessageDialog(null, "Could not find resource!", "Missing Resource", JOptionPane.ERROR_MESSAGE);
	    	
	    }
		try{

			Class.forName ("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url + databaseName, userName, password);
			
		}
		catch(Exception e){
	    	  
			JOptionPane.showMessageDialog(null, "Could not connect to database!", "Connection Error", JOptionPane.ERROR_MESSAGE);
	    	  
		}
		
		return connection;
		
	}
	
	public void disconnect(){
		
		try{
			
			connection.close();
		
		}catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Could not disconnect from database!", "Connection Error", JOptionPane.ERROR_MESSAGE);

		}
	
	}
	
	public ResultSet executeQuery(String statement) throws SQLException{
		
		ResultSet results = null;
		
		try{
			
			Statement stmt = connection.createStatement();
			results = stmt.executeQuery(statement);
		
		}
		catch (SQLException e){
			
			throw e;
			
		}
		
		return results;
		
	}
	
}