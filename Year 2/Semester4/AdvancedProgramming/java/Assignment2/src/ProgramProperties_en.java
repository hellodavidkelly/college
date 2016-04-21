import java.io.IOException;
import java.util.PropertyResourceBundle;

public class ProgramProperties_en extends PropertyResourceBundle
{

	public ProgramProperties_en() throws IOException
	{
		super(ProgramProperties_en.class.getResourceAsStream("ProgramProperties_en.txt"));
	}


}
