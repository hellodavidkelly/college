package lab6.part4;

public class JuniorMathFacade {
	
	public static int absoluteValue(int value){
		int result = Math.abs(value);
		return result;
	}
	
	public static double cubeRoot(double value){
		double result = Math.cbrt(value);
		return result;
	}
	
	public static double squareRoot(double value){
		double result = Math.sqrt(value);
		return result;
	}
	
	public static double xToThePowerOfy(double value1, double value2){
		double result = Math.pow(value1, value2);
		return result;
	}
	
	public static double roundDoubleToInteger(double value){
		double result = Math.rint(value);
		return result;
	}

}
