




// ***********************************************************************
// Reference-based implementation of ADT Doubly Linked List.
// ***********************************************************************
public class DoublyLinkedList implements ListInterface
{
  // reference to linked list of items
  private Node list;     // refs the last item on the list
  private int  numItems; // number of items in list

  public DoublyLinkedList()
  {
    numItems = 0;
    list = null;
  }  // end default constructor

  public boolean isEmpty()
  {
    return numItems == 0;
  }  // end isEmpty

  public int size()
  {
    return numItems;
  }  // end size

  private Node find(int index)
  {
  // --------------------------------------------------
  // Locates a specified node in a linked list.
  // Precondition: index is the number of the desired
  // node. Assumes that 1 <= index <= numItems+1
  // Postcondition: Returns a reference to the desired
  // node.
  // --------------------------------------------------
    Node curr = list.getNext(); // meaning: Reference the first item
    for (int skip = 1; skip < index; skip++)
    {
      curr = curr.getNext();
    } // end for
    return curr;
  } // end find

  /////////////////////////////////////////////////////////////////////////////////
  //  Get Method to retrieve a node at a specific index
  /////////////////////////////////////////////////////////////////////////////////
  public Object get(int index) throws ListIndexOutOfBoundsException
  {
    if (index >= 1 && index <= numItems)
    {
      // get reference to node, then data in node
      Node curr = find(index);
      Object dataItem = curr.getItem();
      return dataItem;
    }
    else
    {
      throw new ListIndexOutOfBoundsException(
                     "List index out of bounds exception on get");
    } // end if
  } // end get

  ///////////////////////////////////////////////////////////////////////
  // Can Add in Four Different Scenarios
  // ------------------------------------------------
  //   (a)
  //
  //   (b) Add to the beginning of an existing list
  //
  //   (c) Add to the end of the List
  //
  //  (d) Add to the middle of the List
  //
  ////////////////////////////////////////////////////////////////////////
  public void add(int index, Object item) throws ListIndexOutOfBoundsException
  {
    if (index >= 1 && index <= numItems+1)
    {
      if (index == 1)    // Adding to the Beginning of the list
   	        if (list == null)
   	            {
   	               	// Option (a)  First node on the list (i.e. When the list is Empty)
					Node newNode = new Node(item, null, null);
					newNode.setNext(newNode);
					newNode.setPrev(newNode);
					list = newNode;
     		    }
		     else
		       {
		     	   // Option (b) Adding to the beginning of an existing list
		       	   Node newNode = new Node(item, list.getNext(), list);
		       	   list.getNext().setPrev(newNode);
		           list.setNext(newNode);
			   }
       else if (index == (numItems+1) )
			  {
			       // Option  (c) Adding to the end of the List
			       Node newNode = new Node(item, list.getNext(), list);
			       list.getNext().setPrev(newNode);
			       list.setNext(newNode);
			       list = newNode;
			   }
       else
              {
			       // Option (d) Adding to the middle of the List
			       Node curr = find(index);
			       Node newNode = new Node(item, curr, curr.getPrev());
			       curr.getPrev().setNext(newNode);
			       curr.setPrev(newNode);
			   }

      numItems++;    // Increment the total number of items due to the new addition
    }

   else
    {
      throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on add");
    }
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////
  //  Remove an Item from the List: Four Options:
  ////////////////////////////////////////////////////////////////////////////////////////////////////////


  public void removeAll()
  {
    // setting head to null causes list to be
    // unreachable and thus marked for garbage
    // collection
    list = null;
    numItems = 0;
  } // end removeAll



  ////////////////////////////////////////////////////////
  //  Display Method - Displays the contents of the list
  ////////////////////////////////////////////////////////
  public void displayList()
  {
	 System.out.println();
     for(int i=1;i<=numItems;i++)
	     System.out.println(this.get(i));
  }


}  // end DoublyLinked List