
public class ProgramResource_fr extends ProgramResource
{

	public Object handleGetObject(String key)
	{
		String returnString="";
		
		if(key.equals("getLocales"))
		{
			returnString = "Montrer tous le Locales";
		}
		
		return returnString;
	}

}
