package lab2.part4.part2;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Address extends JFrame {

	private String city = new String();
	private String houseNumber = new String();
	private String streetName = new String();
	
	Address(){}
	
	public String getCity(){
		return city;
	}
	
	public String getHouseNumber(){
		return houseNumber;
	}
	
	public String getStreetName(){
		return streetName;
	}
	
	public void setCity(String city){	
	}
	
	public void setHouseNumber(String houseNumber){	
	}
	
	public void setStreetName(String streetName){	
	}	
}
