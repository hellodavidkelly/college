
public class thread 
{

	public static void main(String[] args)
	{
		Thread st1 = new Thread(new SimpleThreadTwo("Jamaica"));
		Thread st2 = new Thread(new SimpleThreadTwo("Fiji"));
		Thread st3 = new Thread(new SimpleThreadTwo("Hawaii"));
		
		st1.start();
		st2.start();
		st3.start();
	}

}
