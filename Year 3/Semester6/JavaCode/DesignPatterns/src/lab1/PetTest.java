package lab1;

public class PetTest {

	public static void main(String [] args){

		Pet pet2;
		Pet pet3 = new Pet("Bubba",4);
		Pet pet4 = new Pet("John");
		Pet pet5 = new Pet();
		
		pet2 = new Pet("Jasper","Rabbit", 3);
		
		//Replace pet 3 age
		//pet3.setAge(8);
		pet4.setAnimal("Goat");
		pet5.setAge(9);

		System.out.println("Name"+"\t"+"Animal"+"\t"+"Age");
		System.out.println("-------------------");
		System.out.println(pet2.getName() +"\t"+ pet2.getAnimal() +"\t"+ pet2.getAge());
		System.out.println(pet3.getName() +"\t"+ pet3.getAnimal() +"\t"+ pet3.getAge());
		System.out.println(pet4.getName() +"\t"+ pet4.getAnimal() +"\t"+ pet4.getAge());
		System.out.println(pet5.getName() +"\t"+ pet5.getAnimal() +"\t"+ pet5.getAge());

	}
}
