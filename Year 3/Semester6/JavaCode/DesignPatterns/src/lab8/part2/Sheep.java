package lab8.part2;

public class Sheep extends Animal{

	String name;
	public Sheep(String name){
		this.name = name;
	}
	
	public void details(){
		System.out.println(name+" is a sheep!");
	}
}
