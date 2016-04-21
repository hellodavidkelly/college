import java.io.*;
import java.util.*;

class PowerXY{
    public static void main(String[]args) throws IOException{

          String str;
          int x,y;
          int pow;

          do
          {
           BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
           PrintWriter output = new PrintWriter(System.out);
           output.println("Enter the value for x: ");
           output.flush();
           str = input.readLine();
           x = Integer.parseInt(str);
           output.println("Enter the value for y: ");
		   output.flush();
		   str = input.readLine();
           y = Integer.parseInt(str);

           pow = power(x,y);

           output.println("X to the Power of Y is : " + pow);
	       output.flush();
	      }while (x>0);
    }

    /////////////////////////////////////////////////////
    //   Method to determine the factorial of a number
    /////////////////////////////////////////////////////
    static int power(int x, int y){
        if (y == 1)
            return x;
	   	else
	   		return x * power(x, y-1);
    }

}