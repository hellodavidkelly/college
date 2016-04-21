public class Node 
{
	public Object item; //Data item
	public Node next;
	
/*	public Node(Object newItem)
	{
		item = newItem;
		next = null;
	}*/
	
	public Node(Object newItem, Node nextNode)
	{
	    item = newItem;
	    next = nextNode;		
	}
	
	public Object getItem()
	{
		return item;
	}
	
	public void setNext(Node nextNode)
	{
		next = nextNode;
	}
	
	public Node getNext()
	{
		return next;
	}
}
