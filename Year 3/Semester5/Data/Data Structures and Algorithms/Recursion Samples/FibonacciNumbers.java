import java.io.*;
import java.util.*;

class FibonacciNumbers{
    public static void main(String[]args) throws IOException{

          String str;
          int n;
          int fib;

          do
          {
           BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
           PrintWriter output = new PrintWriter(System.out);
           output.println("Enter the Fibonacci number you would like: ");
           output.flush();
           str = input.readLine();
           n = Integer.parseInt(str);

           fib = getFib(n);

           output.println("Fibonacci Number " + n + " is " + fib);
	       output.flush();
	      }while (n>0);
    }

    /////////////////////////////////////////////////////
    //   Method to determine the factorial of a number
    /////////////////////////////////////////////////////
    static int getFib(int n){
        if (n == 0)    // Seed value F(0) = 0
	   		return 0;
	   	else if(n==1)
	   		return 1;  // Seed value F(1) = 1
	   	else
	   		return getFib(n-1) + getFib(n-2);
    }

}