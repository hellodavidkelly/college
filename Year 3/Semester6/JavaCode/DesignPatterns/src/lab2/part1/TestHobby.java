package lab2.part1;

public class TestHobby extends HobbyList{
	
	public static void main(String [] args){
		
		HobbyList hl;
		hl = new HobbyList();
		
		hl.addHobby("Golf");
		hl.addHobby("Tennis");
		hl.addHobby("Football");
		hl.addHobby("Basketball");
		hl.addHobby("Snooker");
		hl.addHobby("Hurling");
		hl.addHobby("Squash");
		
		Hobby hobby = new Hobby("Golf");
		System.out.println(hl.getHobby());
		System.out.println(hobby);
		
	}
	
	
}
