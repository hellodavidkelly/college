




public class Node
{
  private Object item;
  private Node next;
  private Node prev;


  public Node(Object newItem)
  {
    item = newItem;
    next = null;
    prev = null;
  } // end constructor


  public Node(Object newItem, Node nextNode, Node prevNode)
  {
    item = newItem;
    next = nextNode;
    prev = prevNode;
  } // end constructor

  public void setItem(Object newItem)
  {
    item = newItem;
  } // end setItem

  public Object getItem()
  {
    return item;
  } // end getItem

  public void setNext(Node nextNode)
  {
    next = nextNode;
  } // end setNext

  public Node getNext()
  {
    return next;
  } // end getNext

  public void setPrev(Node prevNode)
  {
    prev = prevNode;
  } // end setNext

  public Node getPrev()
  {
    return prev;
  } // end getNext


} // end class Node

