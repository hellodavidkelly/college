package lab8.part3;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class BritishOilPrice extends JFrame implements Observer, Runnable{

	double britishOilPrice;
	String oilPrice;
	Subject oilPriceIndicator;
	JLabel label;
	
	public BritishOilPrice(Subject oilPriceIndicator){
		super("British Oil");
		this.oilPriceIndicator = oilPriceIndicator;
		oilPriceIndicator.RegisterIntrest(this);
		label = new JLabel(oilPrice);
		this.add(label);
		
		this.setVisible(true);
		this.setLocation(350,0);
		this.setSize(200,100);
	}
	
	@Override
	public void run() {
		while(true){
			try {
				sendNotify(britishOilPrice);
				oilPrice = "Oil Price: "+ britishOilPrice;
				JLabel label = new JLabel(oilPrice);
				this.add(label);
				revalidate();
				Thread.sleep(1000);
				this.remove(label);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void sendNotify(double oilPrice) {
		// TODO Auto-generated method stub
		this.britishOilPrice = oilPrice;
	}

}
