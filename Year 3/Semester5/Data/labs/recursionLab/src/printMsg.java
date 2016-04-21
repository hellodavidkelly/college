public class printMsg 
{
	public void printMsg(int n)
	{
		if(n>0)
		{
			printMsg(n-1);
		}

		System.out.println("Hello "+n);
	}
	
}
