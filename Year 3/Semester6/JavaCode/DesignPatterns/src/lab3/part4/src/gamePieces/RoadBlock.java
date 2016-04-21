package lab3.part4.src.gamePieces;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class RoadBlock extends DamageItem {
	
	public RoadBlock(){
		this.getImage();
	}
	
	public ImageIcon getImage() {
		URL icon = this.getClass().getResource("../../roadblock.jpg");
		return new ImageIcon(icon);
		
	}

}
