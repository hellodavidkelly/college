package lab8.part4;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Unknown implements Chain{

	private Chain nextChain;
	
	@Override
	public void setNextChain(Chain nextChain) {
		// TODO Auto-generated method stub
		this.nextChain = nextChain;
	}

	@Override
	public ImageIcon addImage(ImageIcons request) {
		// TODO Auto-generated method stub
		if(request.selection==3){
			System.out.println("Unknown Selection");
			return null;
		}
		else{
			JOptionPane error = new JOptionPane("Error");
		}
		return null;
	}

}