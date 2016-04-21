
public class testDVD 
{

	public static void main(String[] args) 
	{
		dvd dvd1 = new dvd();
		dvd dvd2 = new dvd();
		dvd dvd3 = new dvd();
		
		dvd1.setTitle("Ferris Buellers Day Off");
		dvd1.setDirector("John Hughes");
		dvd1.setDuration(103);
		
		dvd2.setTitle("Gravity");
		dvd2.setDirector("Alfonso Curon");
		dvd2.setDuration(90);
		
		dvd3.setTitle("Blade Runner");
		dvd3.setDirector("Ridley Scott");
		dvd3.setDuration(113);
		
		System.out.println("TITLE " + "\t\t\t" + " DIRECTOR " + "\t     "  + " DURATION");
		System.out.println(dvd1.getTitle() + "\t" + dvd1.getDirector() + "\t\t" + dvd1.getDuration());
		System.out.println(dvd2.getTitle() + "\t\t\t" + dvd2.getDirector() + "\t\t" + dvd2.getDuration());
		System.out.println(dvd3.getTitle() + "\t\t" + dvd3.getDirector() + "\t\t" + dvd3.getDuration());

	}

}
