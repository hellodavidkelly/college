public class StackTestBasic
{
  public static void main(String[]args){

  String strOrig = "dammitimmad";
  String strRev  = new String();
  StackListBased s1 = new StackListBased();


  for (int i=0; i<strOrig.length(); i++)
     s1.push(strOrig.charAt(i));


  while (!s1.isEmpty())
     strRev+= s1.pop();      // strRev = strRev + s1.pop();


  if (strOrig.equals(strRev))
     System.out.println("YES- PALINDROME :) ");
  else
     System.out.println("NO!! - NOT A PALINDROME ;( ");

  }
}