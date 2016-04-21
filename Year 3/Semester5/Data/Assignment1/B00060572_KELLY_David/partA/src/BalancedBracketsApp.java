import java.io.*;
import java.util.*;

public class BalancedBracketsApp 
{
	
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	public static void main (String [] args) throws IOException
	{
		System.out.print("Enter file name and extension \n");
			System.out.flush();
			
			//////////////
			try
			{
				String fileName = getString();
				File f = new File("/Users/mjrbronchaus/Desktop/" + fileName);
				
				String fullStr = new String();
				
				Scanner input = new Scanner(f);
				while(input.hasNext())
				{
				String str = input.nextLine();
				fullStr += str;
				}
				BracketChecker theChecker = new BracketChecker(fullStr);
				theChecker.check();
				input.close();
			}
			
			catch (FileNotFoundException e)
			{
				System.out.print("File not found with this name.");
			}	
	}//end main
}
