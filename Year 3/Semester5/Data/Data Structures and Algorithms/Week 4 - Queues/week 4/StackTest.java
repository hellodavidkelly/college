public class StackTest
{
  public static final int MAX_ITEMS = 15;

  public static void main(String[] args)
  {
    StackArrayBased stack = new StackArrayBased();

    Integer items[] = new Integer[MAX_ITEMS];

    for (int i=0; i<MAX_ITEMS; i++)
    {
      items[i] = new Integer(i);
      if (!stack.isFull())
      {
        stack.push(items[i]);
      }  // end if
    }  // end for

    while (!stack.isEmpty())
    {
      // cast result of pop to Integer
      System.out.println((Integer)(stack.pop()));
    }  // end while



    System.out.println(isPal("racecar"));

  }  // end main


  public static boolean isPal(String s)
  {
	  StackArrayBased stack = new StackArrayBased();

	  for(int i=0; i< s.length(); i++)
	  {
			stack.push(s.charAt(i));
	  }

	  boolean inLanguage = true;

	  int k=0;

	  while (inLanguage && k < s.length())
	  {
		  char ch = s.charAt(k);

		  try
		  {
			  Object stackTop = stack.pop();

			  if (stackTop.toString().equals(ch + ""))
			  		k++;
			  else
			  		inLanguage = false;
		  }
		  catch (StackException e)
		  {
			  inLanguage = false;
	      }
       }


       return inLanguage;
	}


}