package lab3.part3;

public class LivingThingFactory implements EarthThingsAbstractFactory {

	public Thing getThing() {
		int x = (int) Math.floor(Math.random()*2)+1;
		if(x==1){
			return LivingThing.getThingDog();
		}
		if(x==2){
			return LivingThing.getThingBird();
		}
		return null;
	}

}
