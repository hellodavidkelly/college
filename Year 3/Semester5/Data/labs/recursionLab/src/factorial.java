public class factorial 
{
	
	
	public static int factorialCalc(int n)
	{
		if(n==0)
		{
			return 1;
		}
		
		else
		{
			return(n*factorialCalc(n-1));
			
		}
	}
	
	public static void main (String [] args)
	{
		int x = factorialCalc(5);
		System.out.println(x);
	}
}
