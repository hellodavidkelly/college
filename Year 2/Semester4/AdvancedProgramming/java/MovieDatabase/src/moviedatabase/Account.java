package moviedatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Account{

	Vector<Object> accountV = new Vector<Object>();
	System sys = new System();
	Boolean send = false;
	
	DatabaseEngine databaseEngine = new DatabaseEngine("root", "qwerty");
	
	public void addAccount(String uName, String pass, String email){
		
		generateId();
		addUserName(uName);
		addPassword(pass);
		addEmail(email);
		validate();
		
		if(send){
			
			sendToDatabase();
			
		}
		
	}
	
	public void generateId(){
		
		String userId = "";
		String idNum = "";
		int idNumber = 0;
		String lastId = "";
		Vector<String> v = new Vector<String>();
		
		databaseEngine.connect();
		
		ResultSet results;
		
		try{
			
			results = databaseEngine.executeQuery("select userId from user");
			
	        while(results.next()){
	    		
	        	v.add(results.getString("userId"));
	        		
	        }
	        
		}
		catch (SQLException e){
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "There was a problem while processing the sql!", "SQL Error", JOptionPane.ERROR_MESSAGE);
		
		}
        
		databaseEngine.disconnect();
		
		lastId = v.elementAt(v.size()-1);
		
		for(int i = 0; i < lastId.length(); i++){
			
			if(i > 0){
				
				idNum = idNum + lastId.charAt(i);
				
			}
			
		}
		
		idNumber = Integer.parseInt(idNum);
		idNumber++;
		userId = "U" + idNumber;
		
		accountV.add(userId);
		
	}
	
	public void addUserName(String uName){
		
		accountV.add(uName);
		
	}
	
	public void addPassword(String pass){

		accountV.add(pass);
		
	}
	
	public void addEmail(String email){
		
		accountV.add(email);
		
	}
	
	public void validate(){
		
		databaseEngine.connect();
		
		String resultString = "";
		int restart = 0;
		ResultSet results;
		
		try{
			
			results = databaseEngine.executeQuery("select userName from user where userName = '" + accountV.elementAt(1) + "'");
	        
			results.next();
			resultString = results.getString("userName");
			
		}
		catch (SQLException e){
			
			send = true;
			
		}
		
		databaseEngine.disconnect();
		
		if(!(resultString.equals(""))){
			
			restart = JOptionPane.showConfirmDialog(null, "This username already exists! If you would like to change it you must click ok, change the name and then resubmit, if you no longer want to create an account not click no!", "Movie Already Exists", JOptionPane.OK_OPTION);
			
			if(restart == 1){
				
				sys.redirect();
				
			}
			
		}
		
	}
	
	public void sendToDatabase(){
		
		Connection connection = databaseEngine.connect();
		String statement = "insert into user values(\"" + (String)accountV.elementAt(0) + "\",\"" + (String)accountV.elementAt(1) + "\",\"" + (String)accountV.elementAt(2) + "\",\"" + (String)accountV.elementAt(3) + "\")";
		
		try{
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(statement);
			
		}
		catch (SQLException e){
			
			e.printStackTrace();
			
		}
		
		databaseEngine.disconnect();
		
	}
	
	public void removeAccount(String userName){
		
		Connection connection = databaseEngine.connect();
		String statement = "delete from user where userName = '" + userName + "'";
		
		try{
			
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(statement);
			
		}
		catch (SQLException e){
			
			e.printStackTrace();
			
		}
		
		databaseEngine.disconnect();
		
	}
	
	public Boolean login(String userName, String password){
		
		Boolean loggedIn = false;
		String uName = "";
		String uPassword = ""; 
		databaseEngine.connect();
		String statement = "select userName, userPassword from user where userName = '" + userName + "'";
		ResultSet results;
		
		try{
			
			results = databaseEngine.executeQuery(statement);
	
			results.next();
			
			uName = results.getString("userName");
			uPassword = results.getString("userPassword");
		
		}
		catch (SQLException e){
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Account does not exist.", "No Account Found", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		databaseEngine.disconnect();
		
		if((userName.equals(uName)) && (password.equals(uPassword))){
			
			loggedIn = true;
			
		}
		
		return loggedIn;
		
	}
	
}