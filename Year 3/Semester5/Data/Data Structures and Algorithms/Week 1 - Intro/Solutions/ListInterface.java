// ********************************************************
// Interface ListInterface for the ADT list.
// *********************************************************
public interface ListInterface {
  public boolean isEmpty();
  public int size();
  public void add(int index, Object item)
                  throws ListIndexOutOfBoundsException,
                         ListException;
  public Object get(int index)
                    throws ListIndexOutOfBoundsException;
  public void remove(int index)
                     throws ListIndexOutOfBoundsException;
  public void removeAll();

  public void display();

  //public void append(Object item) throws ListException;   // attach to the end


}  // end ListInterface
