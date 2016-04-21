
public class tryCatchDemo 
{

	static String error = null;
	static int num;
	
	public static void main(String[] args) 
	{
		try
		{
			num = (int)(Math.random()*2)+1;
			System.out.println("Hello World!");
			
			if(num==1)
			{
			error.charAt(3);
			}
		}
/////////////////////////////////////////////////		
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
/////////////////////////////////////////////////				
		finally
		{
			System.out.println("");
			System.out.println("This Always Happens");
		}
	}

}
