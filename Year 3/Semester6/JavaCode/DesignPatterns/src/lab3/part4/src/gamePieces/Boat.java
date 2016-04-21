package lab3.part4.src.gamePieces;

import java.net.URL;

import javax.swing.ImageIcon;

public class Boat extends WaterVehicle {
	public ImageIcon getImage() {
		URL icon = this.getClass().getResource("../../boat.jpg");
		return new ImageIcon(icon);
		
	}
}
