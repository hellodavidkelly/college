package lab2.part4;

public class AdressTest {

	public static void main(String[] args) {
		IRAddress irA = new IRAddress();
		USAddress usA = new USAddress();
		AddressFactory adFac;
		AddressGUI aGUI = new AddressGUI();
		AddressGUIController agc = new AddressGUIController(aGUI, irA, usA);
	}

}
