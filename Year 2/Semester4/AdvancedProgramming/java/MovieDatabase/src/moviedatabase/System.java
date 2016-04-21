package moviedatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

public class System{
	
	DatabaseEngine databaseEngine = new DatabaseEngine("root", "qwerty");
	String userId = "";
	
	public Vector<String> searchMovies(String searchStr){
		
		Vector<String> v = new Vector<String>();
		
		databaseEngine.connect();
		
		ResultSet results;
		
		try{
			
			results = databaseEngine.executeQuery("select * from movie where movieName like '%" + searchStr +"%'");
	        	
	        while(results.next()){
	        		
	        	v.add(results.getString("movieName"));
	        		
	        }
	        
		}
		catch (SQLException e){
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "There was a problem while processing the sql!", "SQL Error", JOptionPane.ERROR_MESSAGE);
		
		}
		
		return v;
		
	}
	
	public Vector<String> searchUsers(String searchStr){
		
		Vector<String> v = new Vector<String>();
		
		databaseEngine.connect();
		
		ResultSet results;
		
		try{
			
			results = databaseEngine.executeQuery("select * from user where userName like '%" + searchStr +"%'");
	        	
	        while(results.next()){
	        		
	        	v.add(results.getString("userName"));
	        		
	        }
	        
		}
		catch (SQLException e){
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "There was a problem while processing the sql!", "SQL Error", JOptionPane.ERROR_MESSAGE);
		
		}
		
		return v;
		
	}
	
	public Vector<String> getMoviePage(String selected){
		
		Vector<String> v = new Vector<String>();
		
		databaseEngine.connect();
		
		ResultSet results;
		
		try{
			
			results = databaseEngine.executeQuery("select * from movie where movieName = '" + selected +"'");
	        	
	        results.next();
	        v.add(results.getString("movieName"));
	        v.add(results.getString("movieYear"));
	        v.add(results.getString("movieDescription"));
	        v.add(results.getString("moviePicture"));
	        
		}
		catch (SQLException e){
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "There was a problem while processing the sql!", "SQL Error", JOptionPane.ERROR_MESSAGE);
		
		}
		
		return v;
		
	}
	
	public void confirm(String message){
		
		JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION);
		
	}
	
	public void notification(String message){
		
		JOptionPane.showMessageDialog(null, message, "Notification", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public void email(){
		
		
		
	}
	
	public void redirect(){
		
		JOptionPane.showMessageDialog(null, "Hello I'm here now", "Hello", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public void displayResults(String id){
		
		
		
	}
	
}