package lab2.part1.part2;

public class MVCTest {

	public static void main(String[] args) {
		ComboView comboView = new ComboView();
		ListView listView = new ListView();
		HobbyList hobbyList = new HobbyList();
		ViewController controller = new ViewController(hobbyList, listView, comboView);
	}

}
