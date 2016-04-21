import java.io.IOException;
import java.util.PropertyResourceBundle;

public class ProgramProperties_fr extends PropertyResourceBundle
{

	public ProgramProperties_fr() throws IOException
	{
		super(ProgramProperties_fr.class.getResourceAsStream("ProgramProperties_fr.txt"));
	}


}
