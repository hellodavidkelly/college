package lab1;

public class DogTest{
	
	public static void main (String [] args){
		
		Dog dog1 = new Dog("Sarge","Dog","Bark",8);
		Dog dog2 = new Dog("Bella","Dog","Sit",4);
		Dog dog3 = new Dog("Bubba","Dog","Jump",2);
		Pet pet1 = new Pet("Goldie", "Monkfish",5);
		
		Pet[] petArray = new Pet[]{dog1,dog2,dog3,pet1,};
		
		for(int x=0;x<petArray.length;x++)
		{
			System.out.println(petArray[x].name);
		}

/////////////////////////////////////////////////////Practice	
/*
		Dog dog2 = new Dog("Harry","Cat","Springer",5);
		Pet pet1 = new Pet("Skip","Kangeroo", 8);
		Pet[] petA = new Pet[5];
		
		for(int x=0; x<petA.length;x++){
			System.out.println(petA[x]);
		}
		System.out.println("Name"+"\t"+"Animal"+"\t"+"Breed"+"\t\t"+"Age");
		System.out.println("-----------------------------------");		
		System.out.println(dog1.getName() +"\t"+ dog1.getAnimal() +"\t"+ dog1.getBreed() +"\t\t"+ dog1.getAge());
		System.out.println(dog2.getName() +"\t"+ dog2.getAnimal() +"\t"+ dog2.getBreed() +"\t"+ dog2.getAge());
		System.out.print("\n\n\n");
		System.out.println("Name"+"\t"+"Animal"+"\t\t"+"Age");
		System.out.println("---------------------------");
		System.out.println(pet1.getName() +"\t"+ pet1.getAnimal() +"\t"+ pet1.getAge());
*/
	}

}
