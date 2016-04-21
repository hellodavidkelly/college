package lab8.part3;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JapanOilPrice extends JFrame implements Observer, Runnable {

	double japanOilPrice;
	String oilPrice;
	Subject oilPriceIndicator;
	JLabel label;
	
	public JapanOilPrice(Subject oilPriceIndicator){
		super("Japan Oil");
		this.oilPriceIndicator = oilPriceIndicator;
		oilPriceIndicator.RegisterIntrest(this);
		label = new JLabel(oilPrice);
		this.add(label);
		
		this.setVisible(true);
		this.setLocation(600,0);
		this.setSize(200,100);
	}
	
	@Override
	public void run() {
		while(true){
			try {
				sendNotify(japanOilPrice);
				oilPrice = "Oil Price: "+ japanOilPrice;
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
		this.japanOilPrice = oilPrice;
	}

}
