package lab2.part4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressGUIController extends Address{

	private AddressFactory addressFactory = new AddressFactory();
	
	public AddressGUIController(AddressGUI addressGUI,IRAddress iraddress, USAddress usaddress){
		iraddress.setVisible(false);
		usaddress.setVisible(false);
		addressGUI = addressGUI;
		addressGUI.addButtonListener(new AddButtonListener());
		iraddress.refreshButtonListener(new RefreshButtonListener());
		usaddress.refreshButtonListener(new RefreshButtonListener());
		
	}

	class AddButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
	
			try{
				if(AddressGUI.getSelectedItem()=="IRELAND"){
					addressFactory.setAddressLocation("IRELAND");
					//irAddress.setVisible(true);
					//AddressGUI.setVisible(false);
				}
				if(AddressGUI.getSelectedItem()=="USA"){
					addressFactory.setAddressLocation("USA");
					//usAddress.setVisible(true);
					//AddressGUI.setVisible(false);
				}
			}
			catch(Exception err){
				System.out.print("Error");
			}
		}
	}
	
	class RefreshButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
	
			try{
				//irAddress.clearFields();
				//usAddress.clearFields();
				System.out.print("HEY");
			}
			catch(Exception err){
				System.out.print("Error");
			}
		}
	}	

}