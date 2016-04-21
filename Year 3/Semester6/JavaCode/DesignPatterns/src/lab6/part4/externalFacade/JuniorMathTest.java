package lab6.part4.externalFacade;

import lab6.part4.JuniorMathFacade;

public class JuniorMathTest {

	static int integer = -8;
	static double double1 = 9;
	static double double2 = 5.9;
	static double double3 = 4.5;
	
	public static void main(String[] args) {
		System.out.println("Absolute Value "+integer+": = " + JuniorMathFacade.absoluteValue(integer));
		System.out.println();
		System.out.println("Cube Root "+double2+": = " + JuniorMathFacade.cubeRoot(double2));
		System.out.println();
		System.out.println("Square Root of "+double1+": = " + JuniorMathFacade.squareRoot(double1));
		System.out.println();
		System.out.println( double1+" To The Power Of "+double3+": = " + JuniorMathFacade.xToThePowerOfy(double1, double3));
		System.out.println();
		System.out.println("Round "+double2+" to the nearest Integer: = " + JuniorMathFacade.roundDoubleToInteger(double2));
		System.out.println();
	}

}
