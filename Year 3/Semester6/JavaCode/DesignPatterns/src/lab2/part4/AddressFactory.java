package lab2.part4;

public class AddressFactory{
	
	public void setAddressLocation(String selectCountry){
		selectCountry.toUpperCase();
		
		if(selectCountry=="IRELAND"){
			new IRAddress();
		}
		if(selectCountry=="USA"){
			new USAddress();
		}
		else{
			System.out.print("INVALID");
		}
	}

}
