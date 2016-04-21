package lab4.part2;

import javax.swing.ImageIcon;

public abstract class AwardingBody {

	String message = new String("Congratulations you are a winner!");
	
	public String getMessage(int finishingPosition){
		return message;
	}
	
	public abstract ImageIcon getPrize(int finishingPosition);
}
