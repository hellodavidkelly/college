




// ****************************************************
// ADT for Doubly Linked List
// ****************************************************
public interface ListInterface
{
  public boolean isEmpty();

  public int size();

  public void add(int index, Object item) throws ListIndexOutOfBoundsException;

   public Object get(int index)  throws ListIndexOutOfBoundsException;

  public void removeAll();

  public void displayList();

} // end ListInterface