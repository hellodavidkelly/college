import java.io.*;

public class checkedVUnchecked 
{

	public static void main(String[] args) 
	{
		unchecked();
		
		try
		{
		checked();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}	

	}
	public static void checked() throws IOException
	{	
	}

	public static void unchecked() throws NullPointerException
	{
	}

/* 
Exception in thread "main" java.lang.Error: Unresolved compilation problem:
	Unhandled exception type IOException
	
	at checkedVUnchecked.main(checkedVUnchecked.java:10)

*
*I had to throw an IOException on the checked method
*/

}