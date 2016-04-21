
public class SimpleThreadTwo implements Runnable
{	
	String country;

	public SimpleThreadTwo(String str)
	{
		country = str;
	}
	
	public void run()
	{
		for(int i=0; i<10;i++)
		{
			System.out.println(i+" "+country);
			
			try
			{
				Thread.sleep((long)(Math.random()*1000));
			}
			catch(InterruptedException e){}	
		}
	
		System.out.println(country + " DONE!");
	}
}
