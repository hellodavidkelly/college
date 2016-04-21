import java.io.*;
import java.util.*;

class MyRecursionTest{
    public static void main(String[]args) throws IOException{

          String str;
          int num;
          int fact;

          do
          {
           BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
           PrintWriter output = new PrintWriter(System.out);
           output.println("Enter the number you wish to find the factorial of: ");
           output.flush();
           str = input.readLine();
           num = Integer.parseInt(str);

           fact = factorial(num);

           output.println("The factorial of " + num + " is " + fact);
	       output.flush();
	      }while (num>0);
    }

    /////////////////////////////////////////////////////
    //   Method to determine the factorial of a number
    /////////////////////////////////////////////////////
    static int factorial(int x){
        if (x == 0)
	   		return 1;
	   	else
	   		return x * factorial(x-1);
    }

}