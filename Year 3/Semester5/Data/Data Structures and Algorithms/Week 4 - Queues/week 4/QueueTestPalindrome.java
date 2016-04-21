public class QueueTestPalindrome{
   public static void main(String[]args){
     System.out.println(isPal("racecar"));

   }
   ///////////////////////////////
   // Test for Pal
   ////////////////////////////////
   static boolean isPal(String str){

      QueueListBased q = new QueueListBased();
      StackListBased s = new StackListBased();

      for(int i=0;i<str.length();i++)
  	    {
			q.enqueue (str.charAt(i));
			s.push(str.charAt(i));
        }

	  while(!s.isEmpty())
		if (s.pop()  != q.dequeue())
		    return false;


       return true;
   }
    /////////////////
}
