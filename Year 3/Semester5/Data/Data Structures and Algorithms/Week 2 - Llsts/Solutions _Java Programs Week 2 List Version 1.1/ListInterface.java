// ****************************************************
// Interface for the ADT list
// ****************************************************

public interface ListInterface
{
  // list operations:
  public boolean isEmpty();

  public int size();

  public void add(int index, Object item) throws ListIndexOutOfBoundsException;

  public void remove(int index) throws ListIndexOutOfBoundsException;

  public Object get(int index)  throws ListIndexOutOfBoundsException;

  public void removeAll();

  public void displayList();

  public void displayBookList();

  public void replace(int index, Object item) throws ListIndexOutOfBoundsException;

  public void appendTraverse(Object item);

  public void append(Object item);

  public Object nextItem();

} // end ListInterface



