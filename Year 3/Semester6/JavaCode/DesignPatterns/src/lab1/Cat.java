package lab1;

public class Cat extends Pet{

	//Construcors
	public Cat(){
	//Empty
		super();
		animal = "Cat";
		
	}
	
	public Cat(String petName){
		super(petName);
	
	}
	//End constructors
	
	//Methods
	//Part:4
	public void feedPet(){
		System.out.println(animal+"\t"+name+"\t"+favFood);
	}
}
