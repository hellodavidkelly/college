import java.util.*;

public class TokenRingNetwork 
{

	public static void main(String args[])
	{
		String[] users = {"Aloysius Amazu",
	    		"Ahmadollah Nazari",
				"Shane Mac Mathuna",
				"Oonagh Maher",
				"Charles John",
				"Inta Buseniece",
				"Michelle Ruth",
				"Aaron Flanagan ",
				"Kevin Nguyen",
				"Mindaugas Kluonis",
				"Bernado Jose",
				"Dmitrij Borovkov",
				"David Breen ",
				"Piotr Masio",
				"Cosmin Mirt",
				"Jesus Lavilla",
				"Diego Malo",
				"Alejandro Menal",
				"Guillermo Ramos",
				"Dereck O Brien",
				"Conor McKeogh",
				"Ciaran O Meara",
				"Bogdans Krutilins",
				"Jonathan Grant",
				"Shane Lowry",
				"David Malone",
				"David Concarr",
				"Conor Smith",
				"John Flood",
				"Ciaran Boland",
				"Andrew Kelly",
				"Szabolcs Kovacs",
				"Ciaran Beirne",
				"Daragh Walshe",
				"Omar Ibrahim",
				"Thomas Colombet",
				"Samuel Louden",
				"Michael James",
				"Jasmine Naami",
				"Alan Leech",
				"Darragh Lambe",
				"Aminu Ojekhebholo",
				"David Cushen",
				"Andrew Meakin",
				"David Kelly",
				"Adem Slavotic",
				"Michael Korb",
				"Martin Deegan-Sheridan",
				"Anthony Creighton",
				"Darren Alder",
				"Keith Somers",
				"Martin Zuber",
				"Keith Rodden",
				"Seth Harbottle",
				"Paul Cairns",
				"Chris Arndt",
				"Mael Pons"};
		
		int count;
		CircularList myList = new CircularList();

		for(int i=0;i<users.length;i++)
		{
			myList.add(i+1, users[i]);
		}

        myList.displayList();
        System.out.println("\n\nThe above users have all logged in\n");
        System.out.println("Logging them all off now at random:\n\n");

        //System.out.print(myList.size());
		
        boolean logoff=false;
    	int ind =0;

        while(users.length>=0)
        {
        	logoff = (Math.random() < 0.5);
        	
        	if(logoff)
        	{
        		ind++;
        		myList.remove(ind);
				System.out.println("USER: " + myList.get(ind) + " Logged Off.");
				System.out.println(ind);

        		
        		if(ind==57)
        		{
    				System.out.println("[All users logged off.]");        			
        		}
        	}
        	
        }
   
   }


}
