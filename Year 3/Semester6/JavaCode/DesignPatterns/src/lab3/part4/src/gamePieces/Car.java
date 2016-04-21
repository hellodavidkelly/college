package lab3.part4.src.gamePieces;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class Car extends LandVehicle {

	public ImageIcon getImage() {
		URL icon = this.getClass().getResource("../../car.jpg");
		return new ImageIcon(icon);
	}

}
