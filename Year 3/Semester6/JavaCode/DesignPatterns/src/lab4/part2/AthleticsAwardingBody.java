package lab4.part2;

import javax.swing.ImageIcon;

public class AthleticsAwardingBody extends AwardingBody{

	public ImageIcon getPrize(int finishingPosition){
		Medal medal = new Medal();
		return medal.getMedal(finishingPosition);
	}
	
	public String getMessage(int finishingPosition){
		if(finishingPosition==0){
			return super.getMessage(finishingPosition);
		}
		return null;
	}
}
