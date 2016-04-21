package lab4.part2;

import javax.swing.ImageIcon;

public class HorseShowAwardingBody extends AwardingBody {

	public ImageIcon getPrize(int finishingPosition){
		Ribbon ribbon = new Ribbon();
		return ribbon.getRibbon(finishingPosition);
	}
	
	public String getMessage(int finishingPosition){
		if(finishingPosition==0){
			return super.getMessage(finishingPosition);
		}
		return null;
	}
}
