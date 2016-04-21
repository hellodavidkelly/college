class TestBookList{

	public static void main(String args[])
	{
		ListReferenceBased myList = new ListReferenceBased();

        Book b1 = new Book();
        Book b2 = new Book("Harry Potter", "Rowling", 4.7);
        Book b3 = new Book("Narnia","Lewis", 9);
        Book b4 = new Book();

        myList.add(1,b1);
        myList.add(2,b2);
        myList.add(3,b3);
        myList.add(4,b4);

        myList.displayBookList();
 	}
}
