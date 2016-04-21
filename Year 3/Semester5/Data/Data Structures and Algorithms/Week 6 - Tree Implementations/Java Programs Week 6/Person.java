public class Person extends KeyedItem
{
  // inherits method getKey that returns the search key
  private FullName name;
  private String phoneNumber;
  private Address address;

  public Person(String id, FullName name, String phone, Address addr)
  {
    super(id);
    this.name = name;
    phoneNumber = phone;
    address = addr;
  }  // end constructor

			/* p454 constructor
			  public Person(String id, FullName name, String phone, Address addr)
			  {
				super(name);
				idNumber = id; // idNumber declared as a private
							  // data field
				phoneNumber = phone;
				address = addr;
			  } // end constructor
			*/

  public String toString()
  {
    return getKey() + "#" + name;
  } // end toString

  // other methods would appear here
}  // end Person