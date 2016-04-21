package lab2.part1;

public class MVCHobby{
	
	public static void main(String [] args){
	ComboView combo = new ComboView();
	ListView listView = new ListView();
	HobbyList hobbyList = new HobbyList();
	ComboViewController controller = new ComboViewController(hobbyList, combo, listView);
	}
}
