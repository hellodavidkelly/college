package lab8.part3;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Iterator;

public class OilPriceIndicator extends JFrame implements Runnable, Subject {

	private ArrayList<Observer> observers;
	
	double price;
	String 	oilPrice;
	JLabel label;
	
	public OilPriceIndicator(){
		observers = new ArrayList<Observer>();
		label = new JLabel(oilPrice);
		this.add(label);
		
		this.setVisible(true);
		this.setLocation(0,0);
		this.setSize(300,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void run() {
		while(true){
			try {
				observers.get(0).sendNotify(price);
				observers.get(1).sendNotify(price);
				price = (double) Math.floor(Math.random()*20.0)+100.0;
				oilPrice = "Oil Price: "+ price + "/Gallon";
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
	public void RegisterIntrest(Observer observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}
}
