package lab3.part3;

import java.util.Vector;

public class EarthMaker {

	static LivingThingFactory livingFac = new LivingThingFactory();
	static NonLivingThingFactory nonLivingFac = new NonLivingThingFactory();

	public static void main(String[] args) {
		Vector<Thing> things = new Vector<Thing>(0,1);
		
		for(int i=0;i<1000;i++){
			int x = (int) Math.floor(Math.random()*2)+1;
			
			if(x==1){
				livingFac.getThing();
				things.add(livingFac.getThing());

			}
			
			if(x==2){
				nonLivingFac.getThing();
				things.add(nonLivingFac.getThing());
			}
		}
		
		for(int i=0;i<things.size();i++){
			System.out.println(things.elementAt(i).name+ ": "+ things.elementAt(i).feature);
		}
	}

}
