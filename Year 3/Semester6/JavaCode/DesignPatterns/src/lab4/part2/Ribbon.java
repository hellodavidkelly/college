package lab4.part2;

import java.net.URL;

import javax.swing.ImageIcon;

public class Ribbon extends Prize{
	URL redUrl = this.getClass().getResource("red_ribbon.png");
	URL blueUrl = this.getClass().getResource("blue_ribbon.png");
	URL yellowUrl = this.getClass().getResource("yellow_ribbon.png");
	ImageIcon red = new ImageIcon(redUrl);
	ImageIcon blue = new ImageIcon(blueUrl);
	ImageIcon yellow = new ImageIcon(yellowUrl);
	
	public ImageIcon getRibbon(int finishing){
		if(finishing==0){
			//System.out.println("red");
			return red;
		}
		if(finishing==1){
			//System.out.println("blue");
			return blue;
		}
		if(finishing==2){
			//System.out.println("yellow");
			return yellow;
		}
			return null;
	}
}
