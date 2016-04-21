import java.io.*;

public class Reader 
{
	public static void main(String [] args) throws Exception
	{
		FileReader file = new FileReader("/Users/mjrbronchaus/Desktop/worked.txt");
		BufferedReader br = new BufferedReader(file);
		
		String text = "";
		String line = br.readLine();
		
		while (line != null)
		{
			text += line;
			line = br.readLine();
		}
		
		System.out.println(text);
	}
}
