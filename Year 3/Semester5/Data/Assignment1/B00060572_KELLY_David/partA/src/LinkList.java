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