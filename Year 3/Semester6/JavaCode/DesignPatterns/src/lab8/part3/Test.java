package lab8.part3;

public class Test {

	
	public static void main(String[] args){

		OilPriceIndicator internationalOilPrice = new OilPriceIndicator(); 
		JapanOilPrice japanOilPrice = new JapanOilPrice(internationalOilPrice);
		BritishOilPrice britishOilPrice = new BritishOilPrice(internationalOilPrice);
		
		new Thread(britishOilPrice).start();
		new Thread(japanOilPrice).start();
		new Thread(internationalOilPrice).start();
	}
	
	public Test(){

	}
}
