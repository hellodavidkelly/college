
public class ThreadsClass
{

	public static void main(String[] args)
	{
		Thread st1 = new Thread(new GUIThread("Ready"));

		st1.start();
		
	}
}
