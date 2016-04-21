//////////////////////////////////////////////////
//
// This is the Driver class with the Main Program
//
/////////////////////////////////////////////////


public class ListDriver{

	public static void main(String[]args){

		//Create  a List ADT (An instance of  list)
		//             i.e.  ADT = Data + Operations

		MyList l = new MyList();

        l.add(1, "Milk");
        l.add(2, "Bread");
        l.add(3, "Eggs");
        l.add(4, "Tea");
        l.display();
	    l.add(2, "Cheese");
        l.display();
        for(int item=1;  item<=l.size();  item++)
	        System.out.println(l.get(item));
        l.add(3, "Coffee");
        l.display();
        1.removeAll();
        1.display();

	}
}