import java.util.*;

public class CircularList 
{
	  //Reference to linked list of items
	  private Node list;     //Refers the last item on the list
	  private int  numItems; //Number of items in list

	public CircularList()
	{
		numItems = 0;
		list = null;
	} 
	
	public boolean isEmpty()
	{
		return numItems == 0;
	} 
	
	public int size()
	{
		return numItems;
	}

	private Node find(int index)
	{
		Node curr = list.getNext(); //Reference the first item
		
		for (int skip = 1; skip < index; skip++)
		{
			curr = curr.getNext();
		}
		
		return curr;
	}

	public Object get(int index) throws ListIndexOutOfBoundsException
	{
		if (index >= 1 && index <= numItems)
		{
			//Reference to node, Data in node
			Node curr = find(index);
			Object dataItem = curr.getItem();
			return dataItem;
		}
		else
		{
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on get");
		}
	}

	public void add(int index, Object item) throws ListIndexOutOfBoundsException
	{
		if (index >= 1 && index <= numItems+1)
		{
			if (index == 1)
			{
				if (list == null) 
				{
					//If only item on list
					//CASE "EMPTY"
					Node newNode = new Node(item, null);
					list = newNode;
					list.setNext(newNode);
				}
				
				else
				{
					//CASE "BEGINING - NOT EMPTY!! "
					//Insert the new node containing item at
					//Beginning of the list
					Node newNode = new Node(item, list.getNext());
					list.setNext(newNode);
				}
			}
			
			else
			{
				//CASE "MIDDLE"
				Node prev = find(index-1);
				//Insert the new node containing item after
				//The node that previous references
				Node newNode = new Node(item, prev.getNext());
				prev.setNext(newNode);
				
				if (index == numItems+1)
				{
					//Adding to the end of the list
					//CASE "END - NOT EMPTY!! "
					list = newNode;
				}
			
			}
			numItems++;
		}
			
		else
		{
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on add");
		}
	}
	
	public void remove(int index) throws ListIndexOutOfBoundsException
	{
		if (index >= 1 && index <= numItems)
		{
			if (index == 1)
			{
				// delete the first node from the list
				Node first = list.getNext();
				list.setNext(first.getNext());
			
				if (numItems == 1)
				{
					// if only one item on list
					list = null;
				}
			}
			
			else
			{
				Node prev = find(index-1);
				//Delete the node after the node that previous
				//References, save reference to node
				Node curr = prev.getNext();
				prev.setNext(curr.getNext());
				
				if (index == numItems) 
				{
					//Deleting from the end of the list
					list = prev;
				}
				
				numItems--;
			}
		}
		
		else
		{
			throw new ListIndexOutOfBoundsException("List index out of bounds exception on remove");
		}
	}

	public void removeAll()
	{
		// setting head to null causes list to be
		// unreachable and thus marked for garbage
		// collection
		list = null;
		numItems = 0;
	}
	  
	public void displayList()
	{
		System.out.println();
		
		for(int i=1;i<=numItems;i++)
		{
			System.out.println(this.get(i));
		}
	}

	public void push(Object item)
	{
		if (list == null) // if this is the only item on list
		{
			Node newNode = new Node(item, null);
			list = newNode;
			list.setNext(newNode);
		}
		
		else
		{
			Node newNode = new Node(item, list.getNext());
			list.setNext(newNode);
		}
		numItems++;
	}

	public void replace(int index, Object item) throws ListIndexOutOfBoundsException
	{
		if (index >= 1 && index <= numItems+1)
		{
			if (index == 1)
			{
				// insert the new node containing item at
				// beginning of list
				Node curr = list.getNext();
				Node newNode = new Node(item,curr.getNext());
				list = newNode;
			}
			
			else
			{
				Node prev = find(index-1);
				Node curr = prev.getNext();
				
				Node newNode = new Node(item, curr.getNext());
				prev.setNext(newNode);
				
				if (index == numItems)
				{
					// replacing at the end of the list
					list = newNode;
				}
			} // end if
		}
		
		else
		{
		  throw new ListIndexOutOfBoundsException("List index out of bounds exception on add");
		} // end if
	}
	
	public void appendTraverse(Object item)
	{
		Node first = list.getNext();
		Node curr  = first.getNext();
		
		// Traverse the circular list
		while(curr != first)
		{
			curr = curr.getNext();
		}
		
		Node newNode = new Node(item, first);
		list = newNode;
	}

	public void append(Object item)
	{
		Node prev = list;
		
		Node newNode = new Node(item, prev.getNext());
		prev.setNext(newNode);
		list = newNode;
		numItems++;
	}
	  
	public Object nextItem()
	{
		Object dataItem = list.getItem();
		return dataItem;
	}
}
