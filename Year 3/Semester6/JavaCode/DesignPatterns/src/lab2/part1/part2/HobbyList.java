package lab2.part1.part2;

import java.util.Vector;

import lab2.part1.part2.Hobby;

public class HobbyList {

	Vector<Hobby> v = new Vector<Hobby>(0,1);
	
	public void addHobby(Hobby newHobby){
		if(v.size()<10){
			v.add(newHobby);
		}
		else{
			System.out.println("Hobby List is full!");
		}
	}
	
	public Vector<Hobby> getHobby(){
		return v;
	}
}
