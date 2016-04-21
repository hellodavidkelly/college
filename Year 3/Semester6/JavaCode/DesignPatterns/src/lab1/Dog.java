package lab1;

public class Dog extends Pet{

	//Attribute
	private String commands;
	
	//Constructors
	public Dog(){
	//Empty
		super();
		animal = "Dog";
		
	}
	
	public Dog(String petName){
		super(petName);
	
	}
	
	public Dog(String petName, String petAnimal, String dogCommands, int petAge){
		super(petName,petAnimal,petAge);
		commands = dogCommands;
		
	}
	//End constructors
	
	//Methods
	public void setCommands(String dogCommands){
	
		commands = dogCommands;
	}
	
	public String getCommands(){
		
		return commands;
	}
	
	//Part:4
	public void feedPet(){
		System.out.println(animal+"\t"+name+"\t"+favFood);
	}
	
/////////////////////////////////////////////////////Practice	
/*	
	public Dog(int petAge){
	//Age
		super (petAge);
		animal = "Dog";
	}
	
	public Dog(String petName){
	//Name
		super(petName);
		animal = "Dog";
		
	}
	
	public Dog(String petName, String dogBreed){
	//Name,Breed
		name = petName;
		breed = dogBreed;
		animal = "Dog";
	}
	
	public Dog(String petName, String dogBreed, int petAge){
	//Name,Breed,Age	
		name = petName;
		breed = dogBreed;		
		age = petAge;
		animal = "Dog";
	}
	
	public Dog(String dogBreed, int petAge, String petName){
	//Breed,Age,Name	
		super(dogBreed,petAge,petName);
		animal = "Dog";
	}
	
	public Dog(String petName, String petAnimal, String dogBreed, int petAge){
	//Name,Animal,Breed,Age
		name = petName;
		animal = "Dog";
		breed = dogBreed;
		age = petAge;
	}
	//Methods
	public void setBreed(String dogBreed){
		
		breed = dogBreed;
	}
	
	public String getBreed(){
		return breed;
	}*/
}
