package lab3.part3;

public abstract class LivingThing extends Thing {

	public static Dog getThingDog(){
		return new Dog();
	}	
	
	public static Bird getThingBird(){
		return new Bird();
	}
}
