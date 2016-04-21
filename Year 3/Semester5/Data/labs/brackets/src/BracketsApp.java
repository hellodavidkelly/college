import java.io.*;
import java.util.*;

class StackX
{
	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public StackX(int s)
	{
		maxSize = s;
		stackArray = new char[maxSize];
		top = -1;
	}
	
	public void push(char j)
	{
		stackArray[++top] = j;
	}

	public char pop()
	{
		return stackArray[top--];
	}
	
	public char peek()
	{
		return stackArray[top];
	}
	
	public boolean isEmpty()
	{
		return (top==-1);
	}
}
///////

class BracketChecker
{
	private String input;
	
	public BracketChecker(String in)
	{
		input = in;
	}
	
	public void check()
	{
		int stackSize = input.length();
		StackX theStack = new StackX(stackSize);
		
		for(int j=0; j<input.length(); j++)
		{
			char ch = input.charAt(j);
			
			switch(ch)
			{
			case '{':
			case '[':
			case '(':
				theStack.push(ch);
				break;
				
			case '}':
			case ']':
			case ')':
				if( !theStack.isEmpty())
				{
					char chx = theStack.pop();
					if(
						(ch=='}' && chx!='{') ||
						(ch==']' && chx!='[') ||
						(ch==')' && chx!='(')	)
						 {
							 System.out.println("Error: " +ch+ " at " +j);
						 }
		
				}
				else
					System.out.println("Error: " +ch+ " at " +j);
					break;
					default:
					break;
					
			}//end switch
		}//end for
		
		if(!theStack.isEmpty())
		{
			System.out.println("Error: Missing Right Delimiter");
		}
		
		
	}//end check
}

///////
public class BracketsApp 
{
	public static void main (String [] args) throws IOException
	{
		String input;
		
		//while(true)
		//{
			System.out.print("Enter file name and extension \n");
			System.out.flush();
			
			//////////////
			String fileName = getString();
			File f = new File("/Users/mjrbronchaus/Desktop/" + fileName);
			
			//////////////		
			//////////////	Code to read entire document and store it	
			//FileInputStream fis = new FileInputStream(f);
			//DataInputStream dis = new DataInputStream(fis);
			//BufferedReader br = new BufferedReader(new InputStreamReader(dis));
			//String str;
			//str = br.readLine();
			//////////////		
			
			try
			{
				Scanner in = new Scanner(f);
				while(in.hasNext())
				{
				String str= in.nextLine();
				BracketChecker theChecker = new BracketChecker(str);
				theChecker.check();
				}
			}
			catch (FileNotFoundException e)
			{
				System.out.print("File not found with this name.");
			}
			
			
			//////////////		
		/*	FileReader file = new FileReader("/Users/mjrbronchaus/Desktop/worked.txt");
			BufferedReader br = new BufferedReader(file);
			input = br.readLine();*/
			
			//if(input.equals(""))
				//break;
			
			//BracketChecker theChecker = new BracketChecker(input);
			//theChecker.check();
		//}//end while
			//////////////		

	}//end main
	
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}
