package lab3.part3;

public class NonLivingThingFactory implements EarthThingsAbstractFactory {
	
	public Thing getThing() {
		int x = (int) Math.floor(Math.random()*2)+1;
		if(x==1){
			return NonLivingThing.getThingIron();
		}
		if(x==2){
			NonLivingThing.getThingRock();
			return NonLivingThing.getThingRock();
		}
		return null;
	}

}
