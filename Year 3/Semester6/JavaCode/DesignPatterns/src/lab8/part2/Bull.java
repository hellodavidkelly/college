package lab8.part2;

public class Bull extends Animal{

	String name;
	
	public Bull(String name){
		this.name = name;
	}
	
	public void details(){
		System.out.println(name+ " is a bull!");
	}
}
