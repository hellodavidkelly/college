class TestLinkedList {

	public static void main(String args[])
	{


		ListReferenceBased myList = new ListReferenceBased();

		myList.add(1,44);
		myList.add(2,65);
    	myList.add(3,30);
		myList.add(4,90);
		myList.add(5,700);
		myList.add(6,90);

		System.out.println(myList.get(3));
		System.out.println(myList.get(4));
		System.out.println(myList.get(5));
		System.out.println(myList.get(6));
		//System.out.println("Largest list item is :" + myList.listLargest());


        //myList.displayList();

        //myList.append(37);

        //myList.displayList();

        //myList.push(21);

        //myList.displayList();
 	}
}
