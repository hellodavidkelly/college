public class CollegeHelper 
{

	public static final int MINCLASSSIZE = 10;
	public static final int MAXCLASSSIZE = 30;
	public static final int PASSGRADE = 40;
	
	public static boolean classSizeWithinLimit(int classSize) 
	{
		if(classSize>=MINCLASSSIZE && classSize<=MAXCLASSSIZE) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}	
	
}