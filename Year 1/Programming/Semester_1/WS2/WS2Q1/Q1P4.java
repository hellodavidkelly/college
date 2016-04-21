/********************************************************/
/*			Name: David Kelly							*/
/*			Date: 4/10/12								*/
/*			Program Name: WS2Q1						*/
/*														*/
/*			Description: This is Question 1 from		*/
/*						 worksheet 2 : part 4			*/
/********************************************************/

class Q1P4{

	public static void main(String[] args){

	//Declared Variables
	int groups, students, result;


	System.out.println ("How many students in the class?..");
	students = Keyboard.readInt();

	System.out.println ("How many groups do you want?...");
	groups = Keyboard.readInt();

		//Declared Variables
		int remainder =  students % groups ;

		result = students / groups;
		System.out.print("Each group should have: ");
		System.out.print(result);
		System.out.println("..people in it");
		System.out.println(" ");
		System.out.print(remainder);
		System.out.println(".....people remaining without a assigned group.");
		System.out.println(" ");
		System.out.println(" ");
		}


}