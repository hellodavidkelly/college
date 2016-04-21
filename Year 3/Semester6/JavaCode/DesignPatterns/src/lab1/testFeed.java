package lab1;

public class testFeed {
	
	public static void main(String [] args){
		
		//Construct pets
		Dog dog1, dog2, dog3;
		Cat cat1, cat2;
		
		//Instantiate pets
		dog1 = new Dog();
		dog2 = new Dog();
		dog3 = new Dog();
		
		cat1 = new Cat();
		cat2 = new Cat();
		
		//Mutate pet attributes
		dog1.setName("Albert");
		dog1.setFavFood("ham");
		
		dog2.setName("Barry");
		dog2.setFavFood("cheese");
		
		dog3.setName("Chaz");
		dog3.setFavFood("eggs");
		
		cat1.setName("David");
		cat1.setFavFood("tuna");
		
		cat2.setName("Eric");
		cat2.setFavFood("bacon");
		
		//Add pets to pet array
		Pet[] petArray = new Pet[]{dog1,dog2,dog3,cat1,cat2};
		
		//Admin: Dislpay style
		System.out.println("Type\tName\tFood");
		System.out.println("----------------------");
		
		//Loop to print out feedPet()
		for(int x=0;x<petArray.length;x++){
			petArray[x].feedPet();
		}
		
	}
}
