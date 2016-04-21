class TestLinkedList {

	public static void main(String args[])
	{


		ListCircular myList = new ListCircular();

		myList.add(1,"Milk");
		myList.add(2,"Sugar");
    	myList.add(3,"Coffee");
		myList.add(4,"Apples");
		myList.add(5,"Oranges");
		myList.add(6,"Bread");


        myList.displayList();
        myList.append("Pringles");
        myList.append("Eggs");
        myList.displayList();

        System.out.println("\n\n\n" + myList.nextItem());

        //myList.push(37);
        //myList.replace(3, "Tea");
        //myList.push(21);

    }



}
