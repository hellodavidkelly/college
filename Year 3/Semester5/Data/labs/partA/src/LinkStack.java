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