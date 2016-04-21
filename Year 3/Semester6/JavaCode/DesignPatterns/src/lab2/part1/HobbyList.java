package lab2.part1;

import java.util.Vector;

public class HobbyList extends Hobby {
	//Attributes
	static Vector<Hobby> v = new Vector<Hobby>(0,1);
	
	Hobby golf = new Hobby("Golf");
	
	//Constructor
	public HobbyList(){
		super("");
		v.add(golf);
	}
	
	//Methods
	public void addHobby(String newHobby){
		if(v.size()<10){
			Hobby hobby = new Hobby(newHobby);
			v.add(hobby);
		}
		else{
			System.out.println("Hobby List is full!");
		}
	}
	
	public static Vector<Hobby> getHobby(){
		return v;
	}

}
