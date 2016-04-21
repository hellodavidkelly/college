import java.io.IOException;
import java.util.PropertyResourceBundle;

public class ProgramProperties_de extends PropertyResourceBundle
{

	public ProgramProperties_de() throws IOException
	{
		super(ProgramProperties_de.class.getResourceAsStream("ProgramProperties_de.txt"));
	}


}
