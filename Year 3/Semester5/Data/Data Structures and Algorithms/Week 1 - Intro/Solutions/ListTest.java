class ListTest{
	public static void main(String[]args){
	  MyList l = new MyList();


	  l.add(1,"Beer");
	  l.add(2,"Pringles");
	  l.add(3,"Milk");
	  l.add(4,"Bread");
	  l.add(5,"Whiskey");


      l.display();
      l.append("Milka Chocolate");
      l.display();

 }
}