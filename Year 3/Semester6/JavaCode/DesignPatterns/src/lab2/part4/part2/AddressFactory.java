package lab2.part4.part2;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AddressFactory {
 
	JFrame usa;
	JFrame ireland;
	
 	public void setAddressLocation(int i){
		
		if(i==0){
			System.out.print("USA");
			usa = new USA();
			usa.setVisible(true);
		}
		
		if(i==1){
			System.out.print("IRELAND");
			ireland = new Ireland();
			ireland.setVisible(true);
		}
	}

}
