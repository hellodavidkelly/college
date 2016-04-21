package lab8.part4;

import javax.swing.ImageIcon;

public class BasketBall implements Chain{

	private Chain nextChain;
	
	@Override
	public void setNextChain(Chain nextChain) {
		// TODO Auto-generated method stub
		this.nextChain = nextChain;
	}

	@Override
	public ImageIcon addImage(ImageIcons request) {
		// TODO Auto-generated method stub
		if(request.selection==1){
			return request.imageIcon;
		}
		else{
			nextChain.addImage(request);
		}
		return null;
	}

}