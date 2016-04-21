




class TestDoublyLinkedList {
	public static void main(String args[])
	{
		DoublyLinkedList myList = new DoublyLinkedList();

		myList.add(1, "Tom");
		myList.add(2, "Mary");
    	myList.add(3, "Jim");
        myList.displayList();

     	myList.add(1, "Jane");
        myList.displayList();

    	myList.add(5, "Sarah");
        myList.displayList();

       	myList.add(2, "Mike");
        myList.displayList();

 	}
}
