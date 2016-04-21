package lab4.part2;

import java.net.URL;

import javax.swing.ImageIcon;

public class Medal extends Prize{
	URL goldUrl = this.getClass().getResource("gold_medal.png");
	URL silverUrl = this.getClass().getResource("silver_medal.png");
	URL bronzeUrl = this.getClass().getResource("bronze_medal.png");
	ImageIcon gold = new ImageIcon(goldUrl);
	ImageIcon silver = new ImageIcon(silverUrl);
	ImageIcon bronze = new ImageIcon(bronzeUrl);
	
	public ImageIcon getMedal(int finishing){
		if(finishing==0){
			//System.out.println("gold");
			return gold;
		}
		if(finishing==1){
			//System.out.println("silver");
			return silver;
		}
		if(finishing==2){
			//System.out.println("bronze");
			return bronze;
		}
		return null;
	}
}
