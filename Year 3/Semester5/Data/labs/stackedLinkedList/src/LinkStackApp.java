import java.io.*;
import java.util.*;

class Link
{
	public char dData; //Data item
	public Link next; //Next link in list
	
	public Link(char dd)
	{
		dData = dd;
	}
	
	public void displayLink()
	{
		System.out.print(dData + "");
	}
}

class LinkList
{
	private Link first; //Reference to first item on list
	
	public LinkList()
	{
		first = null;
	}
	
	public boolean isEmpty()
	{
		return (first==null);
	}
	
	public void insertFirst(char dd) //Insert at start of the list
	{
		Link newLink = new Link(dd); //Make new link
		newLink.next = first; //New link is old first link
		first = newLink;// first is new link
	}
	
	public char deleteFirst() //Delete first item
	{
		Link temp = first; //Save reference to link
		first = first.next;
		return temp.dData; //Return deleted link
	}
	
	public void displayList()
	{
		Link current = first; //Start at the beginning of the list
		while(current != null) //Until the end of the list
		{
			current.displayLink(); //Print data
			current = current.next; //Move to next link
		}
		System.out.println("");
	}
}

class LinkStack
{
	private LinkList theList;
	
	public LinkStack() //Constructor
	{
		theList = new LinkList();
	}
	
	public void push(char j) //Put item on top of stack
	{
		theList.insertFirst(j);
	}
	
	public char pop() //Take item from top of stack
	{
		return theList.deleteFirst();
	}
	
	public boolean isEmpty() //True if stack is empty
	{
		return (theList.isEmpty());
	}
	
	public void displayStack()
	{
		System.out.print("Stack (Top-->Bottom): ");
		theList.displayList();
	}
}


public class LinkStackApp 
{
	public static void main(String[] args) throws IOException
	{
		LinkStack theStack = new LinkStack(); //Make a stack

		theStack.push('A');		
		theStack.push('B');		
		theStack.push('C');		
		theStack.push('D');	
		theStack.displayStack();
		theStack.pop();
		theStack.displayStack();
		theStack.push('E');		
		theStack.push('F');		
		theStack.displayStack();
	}
	
	public static char getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		char s = (char) br.read();
		return s;
	}
}
