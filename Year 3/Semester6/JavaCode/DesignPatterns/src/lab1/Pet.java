package lab1;

public class Pet {
	
	//Attributes
	protected String name;
	protected String animal;
	protected int age;
	//Part:4
	protected String favFood;

	//Constructors
	public Pet(){
	//Empty	
	}
	
	public Pet(String petName){
	//Name
		name = petName;
	}
	
	public Pet(int petAge){
	//Age
		age = petAge;
	}
	
	public Pet(String petName, int petAge){
	//Name,Age	
		name = petName;
		age = petAge;
	}
	
	public Pet(String petName, String petAnimal, int petAge){
	//Name,Animal,Age	
		name = petName;
		animal = petAnimal;
		age = petAge;
	}
	//End constructors
	
	//Methods
	public void setName(String petName){
		name = petName;
	}
	
	public String getName(){
		return name;
	}
	
	public void setAge(int petAge){
		age = petAge;
	}
	
	public int getAge(){
		return age;
	}
	
	public void setAnimal(String petAnimal){
		animal = petAnimal;
	}
	
	public String getAnimal(){
		return animal;
	}
	
	//Part:4
	public void feedPet(){
	}
	
	public void setFavFood(String petFood){
		favFood = petFood;
	}
	
	public String getFavFood(){
		return favFood;
	}
	//End methods
}
