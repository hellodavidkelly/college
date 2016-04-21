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
		
		CircularList myList = new CircularList();

		for(int i=0;i<users.length;i++)
		{
			myList.add(i+1, users[i]);
		}

        myList.displayList();
        System.out.println("Number of users left: "+myList.size());
        System.out.println("\n\nThe above users have all logged in\n");
        System.out.println("Logging them all off now in circle:\n\n");

        //System.out.print(myList.size());
		
        boolean logoff=false;
    	int i=0;
    	int j=0;
        while(myList.size()>1)
        {
        	logoff = (Math.random() < 0.5);
			
        	if(logoff)				
    		{
				System.out.println("\nUSER: " + myList.get(myList.size()-i) + " Logged Off.");
        		myList.remove(myList.size()-i);
        		j++;
                if(i>=myList.size())
				{
					i=0;
				}
    		}
			
			else
			{
				i++;
				if(i>=myList.size())
				{
					i=0;
				}

			}
        	
        }
        
		/*if(myList.size()==1)
		{
			System.out.println("USER: " + myList.get(myList.size()) + " Logged Off.");
            myList.remove(myList.size());
    		System.out.println("Number of users left: 0");

    	}*/
		
		System.out.println("\nALL USERS LOGGED OUT");
   }


}
