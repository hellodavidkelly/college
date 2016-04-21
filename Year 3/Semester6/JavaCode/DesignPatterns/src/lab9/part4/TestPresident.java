package lab9.part4;

public class TestPresident {

	static President dave = President.createPresident(35, "Dave");
	static President john = President.createPresident(50, "John");
	
	public static void main(String[] args) {
		dave.getAge();
		dave.getName();
		john.getAge();
		john.getName();
	}

}
