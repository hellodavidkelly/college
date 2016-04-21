package lab3.part3;

public abstract class NonLivingThing extends Thing{

	public static Iron getThingIron(){
		return new Iron();
	}	
	
	public static Rock getThingRock(){
		return new Rock();
	}
}
