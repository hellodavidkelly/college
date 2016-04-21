class Link
{
	public int iData; //Data Item
	public double dData; //Data Item
	public Link next; //Next link in the list
	
	public Link(int id, double dd)//Constructor
	{
		iData = id;
		dData = dd;
		//next is automatically set to null
	}
	
	public void displayLink()
	{
		System.out.print("{" + iData + ", " + dData + "}");
	}
}

class LinkList
{
	private Link first; //Reference to the first link on list
	
	public LinkList()
	{
		first = null; //No items on the list yet
	}
	
	public boolean isEmpty()
	{
		return (first==null);
	}
	
	public void insertFirst(int id, double dd)
	{
		Link newLink = new Link(id,dd); //Make a new link
		newLink.next = first; 
		first = newLink;
	}
	
	public Link deleteFirst()
	{
		Link temp = first; //Save reference to link in temp
		first = first.next; //first is now the old next link
		return temp; //Return deleted link
	}
	
	public void displayList()
	{
		System.out.print("List (first--> last): ");
		
		Link current = first; //Start at beginning of list
		
		while(current!=null)
		{
			current.displayLink(); //Print data
			current = current.next; //Move to next link
		}
		System.out.print("");
	}
}
public class LinkListApp 
{
	public static void main(String [] args)
	{
		LinkList theList = new LinkList(); //Make new list
		
		theList.insertFirst(22, 2.99);
		theList.insertFirst(44, 4.99);
		theList.insertFirst(66, 6.99);
		theList.insertFirst(88, 8.99);
		
		theList.displayList();
		
		while( !theList.isEmpty())
		{
			Link aLink = theList.deleteFirst(); //Delete link
			System.out.print("\n Deleted"); //Display deleted link
			aLink.displayLink();
			System.out.println("");
		}
		
		theList.displayList(); //Display list
	}
}
