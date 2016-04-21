package moviedatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Movie{
	
	Vector<Object> movieV = new Vector<Object>();
	System sys = new System();
	Boolean send = false;
	
	DatabaseEngine databaseEngine = new DatabaseEngine("root", "qwerty");

	public void addMovie(String name, int year, String description, String picUrl){
		
		generateId();
		addName(name);
		addYear(year);
		addDescription(description);
		addPicture(picUrl);
		validate(description);
		
		if(send){
			
			sendToDatabase();
			
		}
		
	}
	
	public void generateId(){
		
		String movieId = "";
		String idNum = "";
		int idNumber = 0;
		String lastId = "";
		Vector<String> v = new Vector<String>();
		
		databaseEngine.connect();
		
		ResultSet results;
		
		try{
			
			results = databaseEngine.executeQuery("select movieId from movie");
			
	        while(results.next()){
	    		
	        	v.add(results.getString("movieId"));
	        		
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
		movieId = "M" + idNumber;
		
		movieV.add(movieId);
		
	}
	
	public void addName(String name){
		
		movieV.add(name);
		
	}
	
	public void addYear(int year){

		movieV.add(year);
		
	}
	
	public void addDescription(String description){
		
		movieV.add(description);
		
	}
	
	public void addPicture(String picUrl){
		
		movieV.add(picUrl);
		
	}
	
	public void validate(String search){
		
		databaseEngine.connect();
		
		String resultString = "";
		int restart = 0;
		ResultSet results;
		
		try{
			
			results = databaseEngine.executeQuery("select movieName from movie where movieName = '" + search + "'");
	        
			results.next();
			resultString = results.getString("movieName");
			
		}
		catch (SQLException e){
			
			send = true;
			
		}
		
		databaseEngine.disconnect();
		
		if(!(resultString.equals(""))){
			
			restart = JOptionPane.showConfirmDialog(null, "This movie already exists! If you would like to submit it anyway you must click ok, change the name and then resubmit, if not click no!", "Movie Already Exists", JOptionPane.OK_OPTION);
			
			if(restart == 1){
				
				sys.redirect();
				
			}
			
		}
		
	}
	
	public void sendToDatabase(){
		
		Connection connection = databaseEngine.connect();
		
		String statement = "insert into movie values(\"" + (String)movieV.elementAt(0) + "\",\"" + (String)movieV.elementAt(1) + "\"," + (int)movieV.elementAt(2) + ",\"" + (String)movieV.elementAt(3) + "\",\"" + (String)movieV.elementAt(4) + "\",\"U2\")";
		
		try{
			
			Statement stmt = connection.createStatement();
			
			stmt.executeUpdate(statement);
			
		}
		catch (SQLException e){
			
			e.printStackTrace();
			
		}
		
		databaseEngine.disconnect();
		
	}

}