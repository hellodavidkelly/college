public class TestPalindrome{
   public static void main(String[]args){

    Character ch;
    boolean isPal = true;

    StackReferenceBased s = new	StackReferenceBased();
	QueueReferenceBased q = new QueueReferenceBased();

    String str = new String();
    System.out.print("Please Enter your String : ");
    str = Keyboard.readString();

    // push onto stack AND queue onto the queue
    for (int i=0; i<str.length(); i++)
	{
		s.push((Character) str.charAt(i));
        q.enqueue((Character) str.charAt(i));
    }

    while (!s.isEmpty() && !q.isEmpty() && isPal == true )
      if ((Character) s.pop() != (Character) q.dequeue())
          isPal = false;

     if (isPal == true)
         System.out.println("YES, its a Palindrome!!");
     else
         System.out.println("NO!, its  NOT a Palindrome!!");
  }
}