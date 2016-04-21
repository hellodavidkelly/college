
public class shoppingList {

	public shoppingList()
	{
		
	}
	
	public static void main(String[] args) 
	{
		ArrayList shoppingList = new ArrayList();
		shoppingList.add(1, "bread");
		shoppingList.add(2, "milk");
		shoppingList.add(3, "eggs");
		shoppingList.add(4, "beans");
		shoppingList.add(5, "cheese");

		for(int i=0;i<=4;i++)
		{
		System.out.print(shoppingList);
		}
	}

}
