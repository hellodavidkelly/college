package moviedatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Review{

	Vector<Object> reviewV = new Vector<Object>();
	System sys = new System();
	Boolean send = false;

	DatabaseEngine databaseEngine = new DatabaseEngine("root", "qwerty");
	
	public void addReview(String name, String description, int rating){
		
		generateId();
		addName(name);
		addDescription(description);
		addRating(rating);
		sendToDatabase();
	
	}
	
	public void generateId(){
		
		String reviewId = "";
		String idNum = "";
		int idNumber = 0;
		String lastId = "";
		Vector<String> v = new Vector<String>();
		databaseEngine.connect();
		
		ResultSet results;
		
		try{
			
			results = databaseEngine.executeQuery("select reviewId from review");
			
	        while(results.next()){
	    		
	        	v.add(results.getString("reviewId"));
	        		
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
		reviewId = "R" + idNumber;
		
		reviewV.add(reviewId);
		
		
	}
	
	public void addName(String name){
		
		reviewV.add(name);
		
	}
	
	public void addDescription(String description){
		
		reviewV.add(description);
		
	}
	
	public void addRating(int rating){
		
		reviewV.add(rating);
		
	}
	
	public void sendToDatabase(){

		Connection connection = databaseEngine.connect();
		
		String statement = "insert into review values(\"" + (String)reviewV.elementAt(0) + "\",\"" + (String)reviewV.elementAt(1) + "\",\"" + (String)reviewV.elementAt(2) + "\",\"" + (int)reviewV.elementAt(3) + "\",\"M1\",\"U2\")";
		
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