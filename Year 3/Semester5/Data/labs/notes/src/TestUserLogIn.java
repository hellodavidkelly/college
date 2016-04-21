
class TestUserLogIn{
	public static void main(String args[])
	{

		int count;
		ListCircular myList = new ListCircular();


		// Login a list of Users
		myList.add(1,"Arnie");
		myList.add(2,"Michael");
    	myList.add(3,"Orla");
		myList.add(4,"Markus");
		myList.add(5,"Simon");
		myList.add(6,"Laura");

        myList.displayList();
        System.out.println("\n\nThe above users have all logged in\n");
        System.out.println("Logging them all off now at random:\n\n");

        count = myList.size();

        while(count>0)
        {
          int user = (int)(Math.random()*10000%count+1);
          myList.remove(user);
          try {
    	    Thread.sleep(1000);
		  } catch(InterruptedException e){
		  }

          myList.displayList();
          count = myList.size();
        }
   }
}
