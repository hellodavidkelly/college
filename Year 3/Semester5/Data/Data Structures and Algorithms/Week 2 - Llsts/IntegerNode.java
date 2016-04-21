public class IntegerNode
{
  private int item;
  private IntegerNode next;

  public IntegerNode(int newItem)
  {
    item = newItem;
    next = null;
  } // end constructor

  public IntegerNode(int newItem, IntegerNode nextNode)
  {
    item = newItem;
    next = nextNode;
  } // end constructor

  public void setItem(int newItem)
  {
    item = newItem;
  } // end setItem

  public int getItem()
  {
    return item;
  } // end getitem

  public void setNext(IntegerNode nextNode)
  {
    next = nextNode;
  } // end setNext

  public IntegerNode getNext()
  {
    return next;
  } // end getNext

}  // end class IntegerNode