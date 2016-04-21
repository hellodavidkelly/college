/********************************************************/
/*			Name: David Kelly							*/
/*			Date: 4/10/12								*/
/*			Program Name: WS2Q9							*/
/*														*/
/*			Description: This is Question 9 from		*/
/*						 worksheet 2 : convertion		*/
/********************************************************/

class Q9P1{

	public static void main(String[] args){

		double Tf;
		System.out.println("Please enter the temperature in degrees Fahrenheit");
		Tf = Keyboard.readDouble();

		double Tc;
		Tc = (5.0 / 9.0) * (Tf - 32);
		System.out.println(Tf + " is " + Tc + " degrees celcius");


		}

	}