package lab5.part3;

import javax.swing.JPanel;

public class DirectorFactory {

	public JPanel choice(int selection){
		if(selection == 0){
			return new LegoMan().getPanel();
		}
		if(selection == 1){
			return new StickMan().getPanel();
		}
		return null;
	}
}
