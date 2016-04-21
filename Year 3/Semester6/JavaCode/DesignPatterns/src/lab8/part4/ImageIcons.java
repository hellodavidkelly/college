package lab8.part4;

import javax.swing.ImageIcon;

public class ImageIcons {
	
	int selection;
	ImageIcon imageIcon;
	
	
	public ImageIcons(ImageIcon imageIcon, int selection){
		this.imageIcon = imageIcon;
		this.selection = selection;
	}
	
	public int getSelected(){
		return selection;
	}
	
	public ImageIcon getImageIcon(){
		return imageIcon;
	}
}
