// ****************************************************
// Reference-based implementation of ADT list.
// ****************************************************

public class ListCircular implements ListInterface
{
  // reference to linked list of items
  private Node list;     // refs the last item on the list
  private int  numItems; // number of items in list

  public ListCircular()
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

  /////////////////////////////////////////////////////////////
  //
  /////////////////////////////////////////////////////////////
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
  //
  //
  //
  ///////////////////////////////////////////////////////////////////////
  public void add(int index, Object item) throws ListIndexOutOfBoundsException
  {
    if (index >= 1 && index <= numItems+1)
    {
      if (index == 1)
      {
        if (list == null) // if this is the only item on list
		 // CASE "EMPTY"
		 {
			Node newNode = new Node(item, null);
		    list = newNode;
		    list.setNext(newNode);
		 }
        else
         {
           // CASE "BEGINING - NOT EMPTY!! "
          // insert the new node containing item at
          // beginning of the list
          Node newNode = new Node(item, list.getNext());
          list.setNext(newNode);
	     }
     }
    else
      {
        // CASE "MIDDLE"
        Node prev = find(index-1);
        // insert the new node containing item after
        // the node that prev references
        Node newNode = new Node(item, prev.getNext());
        prev.setNext(newNode);
        if (index == numItems+1) // Adding to the end of the list
            // CASE "END - NOT EMPTY!! "
           list = newNode;

       } // end if
      numItems++;
    }
    else
    {
      throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on add");
    } // end if
  }  // end add

  public void remove(int index) throws ListIndexOutOfBoundsException
  {
    if (index >= 1 && index <= numItems)
    {
      if (index == 1)
      {
        // delete the first node from the list
        Node first = list.getNext();
        list.setNext(first.getNext());

        if (numItems == 1) // if only one item on list
             list = null;
      }
      else
      {
        Node prev = find(index-1);
        // delete the node after the node that prev
        // references, save reference to node
        Node curr = prev.getNext();
        prev.setNext(curr.getNext());
        if (index == numItems) // Deleting from the end of the list
             list = prev;

      } // end if
      numItems--;
    } // end if
    else
    {
      throw new ListIndexOutOfBoundsException(
                   "List index out of bounds exception on remove");
    } // end if
  }   // end remove

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

  ////////////////////////////////////////////////////////
  //  Display Books Only
  ////////////////////////////////////////////////////////
  public void displayBookList()
  {
  	 System.out.println();
  	 for(int i=1;i<=numItems;i++){
	   Book b = (Book) this.get(i);
	   b.displayBook();
     }
  }


  //////////////
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

  ////////////////////////////////////////////////////////
  //  Replace Method
  ////////////////////////////////////////////////////////
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
        if (index == numItems) // replacing at the end of the list
             list = newNode;
      } // end if
    }
    else
    {
      throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on add");
    } // end if
  }


    //////////////////////////////////////////////////////
    // Append to the end of the list (using a traverse)
    //////////////////////////////////////////////////////
    public void appendTraverse(Object item)
    {
       Node first = list.getNext();
	   Node curr  = first.getNext();

	   // Traverse the circular list
	   while(curr != first)
		 curr = curr.getNext();


	   Node newNode = new Node(item, first);
       list = newNode;
    }


  ///////////////////////////////////////////////////
  // Append to the end of the list (using the tail)
  ///////////////////////////////////////////////////
  public void append(Object item)
  {
       Node prev = list;

       Node newNode = new Node(item, prev.getNext());
	   prev.setNext(newNode);
	   list = newNode;
       numItems++;
  }

  ////////////////////////////////////////////////////////
  //  Return Next item
  ////////////////////////////////////////////////////////
  public Object nextItem()
  {
 	  Object dataItem = list.getItem();
      return dataItem;
  }


} // end ListReferenceBased