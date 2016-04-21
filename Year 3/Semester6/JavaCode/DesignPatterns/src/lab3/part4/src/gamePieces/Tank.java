package lab3.part4.src.gamePieces;
import java.net.URL;

import javax.swing.ImageIcon;

public class Tank extends LandVehicle {

	public ImageIcon getImage() {
		URL icon = this.getClass().getResource("../../tank.jpg");
		return new ImageIcon(icon);
		
	}

}
