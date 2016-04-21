
public class cdTest 
{

	public static void main(String[] args) 
	{
		compactDisc cd1 = new compactDisc();
		compactDisc cd2 = new compactDisc();
		compactDisc cd3 = new compactDisc();
		compactDisc cd4 = new compactDisc();
		compactDisc cd5 = new compactDisc();

		cd1.setTitle("Kid A");
		cd2.setTitle("The Bends");
		
		cd3.setTitle("Modern Vampires of the City");
		cd4.setTitle("Is This It?");
		cd5.setTitle("Humbug");
		
		cd3.setArtist("Vampire Weekend");
		cd4.setArtist("The Strokes");
		cd5.setArtist("Arctic Monkeys");
		
		cd3.setTrackNum(9);
		cd4.setTrackNum(8);
		cd5.setTrackNum(14);
		
		cd3.setfavTrack("Step");
		cd4.setfavTrack("Soma");
		cd5.setfavTrack("Brick By Brick");
		
		
		
		System.out.println("cd1 title = " + cd1.getTitle());
		System.out.println("cd2 title = " + cd2.getTitle());
		
		System.out.println("cd3 title:" + cd3.getTitle() + " Artist:" + cd3.getArtist() + " Tracks:" + cd3.getTrackNum() + " Favorite:" + cd3.getfavTrack());
		System.out.println("cd4 title:" + cd4.getTitle() + " Artist:" + cd4.getArtist() + " Tracks:" + cd4.getTrackNum() + " Favorite:" + cd4.getfavTrack());
		System.out.println("cd5 title:" + cd5.getTitle() + " Artist:" + cd5.getArtist() + " Tracks:" + cd5.getTrackNum() + " Favorite:" + cd5.getfavTrack());


	}

}
