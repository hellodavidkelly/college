import java.io.*;

class ReverseApp
{
	public static void main (String [] args) throws IOException
	{
		String input, output;
		
		while(true)
		{
			System.out.print("Enter a string: ");
			System.out.flush();
			input = getString(); //read string from kbd
		
			if(input.equals(""))
				break;
			
			Reverser theReverser = new Reverser(input); //make a reverser
			output = theReverser.doRev(); // use it
			
			System.out.println("Reversed: " + output);
		}
	}
	
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		
		return s;
	}
}

//////////////////////////////////////////////
class StackX 
{	
	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public StackX (int max) //constructor
	{
		maxSize = max;
		stackArray =  new char[maxSize];
		top = -1;
	}
	
	public void push(char j) //put item in to stack
	{
		stackArray[++top] =j;
	}
	
	public char pop() //take item from top of stack
	{
		return stackArray[top--];
	}
	
	public char peek()
	{
		return stackArray[top];
	}
	
	public boolean isEmpty()
	{
		return (top == -1);
	}
}

//////////////////////////////////////////////////////////

class Reverser
{
	private String input;
	private String output;

	public Reverser(String in) //constructor
	{
		input = in;
	}

	public String doRev() //do reverse of the string
	{
		int stackSize = input.length(); //get max stack size
		StackX theStack = new StackX(stackSize); //make stack
		
		for(int j=0; j<input.length(); j++)
		{
			char ch = input.charAt(j); //get char from input
			theStack.push(ch); //push it
		}
		
		output = "";
		
		while(!theStack.isEmpty())
		{
			char ch = theStack.pop(); // take a char from the top of the stack
			output = output + ch; // append the char to the output
		}
		
		return output;
	}
}

//////////////////////////////////////////////////////////

