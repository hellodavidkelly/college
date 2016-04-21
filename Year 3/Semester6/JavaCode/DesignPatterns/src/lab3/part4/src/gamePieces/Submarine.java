package lab3.part4.src.gamePieces;
import java.net.URL;

import javax.swing.ImageIcon;

public class Submarine extends WaterVehicle {

	public ImageIcon getImage() {
		URL icon = this.getClass().getResource("../../sub.jpg");
		return new ImageIcon(icon);
		
	}
	
}
