
public class test1 
{

	int x =9;
	
	public test1(int x)
	{
		this.x=x;
	}
	
	public static void main(String[] args) 
	{
		System.out.println(x);

		test1 t = new test1(5);
		
		System.out.println(t.x);
	}

}
