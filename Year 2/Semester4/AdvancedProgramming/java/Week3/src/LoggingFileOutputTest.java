import java.io.IOException;
import java.util.logging.*;

public class LoggingFileOutputTest 
{

	public static void main(String[] args) 
	{
		Logger logException = Logger.getLogger("exception.file.example");
		try 
		{
			Object s = null;
			s.toString();
		}
		catch(NullPointerException ex) 
		{
			try 
			{
				Handler fileOut = new FileHandler("errorLog.txt", true);
				fileOut.setFormatter(new SimpleFormatter());
				logException.addHandler(fileOut);
			}
			catch(IOException ioEx) 
			{
				//ignored
			}
			logException.log(Level.SEVERE,"An exception occurred in here");
		}
	}
}
