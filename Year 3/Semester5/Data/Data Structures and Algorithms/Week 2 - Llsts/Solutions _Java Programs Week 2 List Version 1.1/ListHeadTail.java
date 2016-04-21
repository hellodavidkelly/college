// ****************************************************
// Reference-based implementation of ADT list.
// ****************************************************

public class ListHeadTail implements ListInterface
{
  // reference to linked list of items
  private Node head;
  private Node tail;
  private int numItems; // number of items in list

  public ListHeadTail()
  {
    numItems = 0;
    head = null;
    tail = null;
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
    Node curr = head;
    for (int skip = 1; skip < index; skip++)
    {
      curr = curr.getNext();
    } // end for
    return curr;
  } // end find

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





  public void add(int index, Object item) throws ListIndexOutOfBoundsException
  {
    if (index >= 1 && index <= numItems+1)
    {
      if (index == 1)               // OPTION (A) Add to Start of list
       {
        // insert the new node containing item at
        // beginning of list
        Node newNode = new Node(item, head);
        head = newNode;
        if (tail == null) // if this is the only item on list
             tail = newNode;
       }
      else if (index == numItems+1) // OPTION (B) Add to End of list
	   {
	     Node newNode = new Node(item);
         tail.setNext(newNode);
         tail = newNode;
	   }
      else
       {
        Node prev = find(index-1);  // OPTION (C) Add elsewhere in the list
        // insert the new node containing item after
        // the node that prev references
        Node newNode = new Node(item, prev.getNext());
        prev.setNext(newNode);
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
        head = head.getNext();
        if (numItems == 1) // if only one item on list
             tail = null;
      }
      else
      {
        Node prev = find(index-1);
        // delete the node after the node that prev
        // references, save reference to node
        Node curr = prev.getNext();
        prev.setNext(curr.getNext());
        if (index == numItems) // Deleting from the end of the list
             tail = prev;

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
    head = null;
    tail = null;
    numItems = 0;
  } // end removeAll



  ////////////////////////////////////////////////////////
  //  Display Method - Displays the contents of the list
  ////////////////////////////////////////////////////////
  public void displayList()
  {  // Inefficient implementation
     //  Why?
     //  How could you make it efficient?
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
     Node newNode = new Node(item, head);
     head = newNode;
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
        Node newNode = new Node(item, head.getNext());
        if (head==tail)
           tail = newNode;
        head = newNode;

     }
      else
      {
        Node prev = find(index-1);
        Node curr = find(index);

        Node newNode = new Node(item, curr.getNext());
        prev.setNext(newNode);
        if (index == numItems) // Deleting from the end of the list
             tail = newNode;
      } // end if
    }
    else
    {
      throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on add");
    } // end if
  }

  ///////////////////////////////////////////////////
  // Append to the end of the list (using a traverse)
  ///////////////////////////////////////////////////
  public void appendTraverse(Object item)
  {
       Node prev = find(numItems-1);
       Node newNode = new Node(item, prev.getNext());
       prev.setNext(newNode);
       tail = newNode;
       numItems++;
  }

  ///////////////////////////////////////////////////
  // Append to the end of the list (using the tail)
  ///////////////////////////////////////////////////
  public void append(Object item)
  {
       Node prev = tail;
       Node newNode = new Node(item, prev.getNext());
       prev.setNext(newNode);
       tail = newNode;
       numItems++;
  }

 ////////////////////////////////////////////////////////
  //  Return Next item
  ////////////////////////////////////////////////////////
  public Object lastItem()
  {
     return tail.getItem();
  }


} // end ListReferenceBased