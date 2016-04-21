package lab3.part4.src.gamePieces;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class SeaMine extends DamageItem {

	public SeaMine(){
		this.getImage();
	}
	
	public ImageIcon getImage() {
		URL icon = this.getClass().getResource("../../seamine.jpg");
		return new ImageIcon(icon);
		
	}

}
