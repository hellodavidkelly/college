package lab2.part4.part2;

import java.util.Vector;

public class AddressStorage {

	static Vector<String> addressVector = new Vector<String>(0,1);

	public static void addAddress(String address){
		addressVector.add(address);
	}
	
	public static String getAddress(){		
		for(int i=0; i<addressVector.size();i++){
			return addressVector.elementAt(i);
		}
		return null;
	}
}
