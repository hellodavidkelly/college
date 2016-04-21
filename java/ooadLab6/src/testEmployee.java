public class testEmployee 
{

	public static void main(String[] args) 
	{
		employee emp1 = new employee();
		employee emp2 = new employee();
		employee emp3 = new employee();
		
		emp1.setName("Gerry Barlow");
		emp1.setAddress("13, Tyneside vally, Co.Carlow");
		emp1.setPhoneNum(457333);
		
		emp2.setName("Bobbie Williams");
		emp2.setAddress("Biker hill, bray, Co.Dublin");
		emp2.setPhoneNum(743943);
		
		emp3.setName("Mark Eoin");
		emp3.setAddress("155, Longfield view, Co.Down");
		emp3.setPhoneNum(443743);
		
		emp1.display();
		emp2.display();
		emp3.display();

	}

}
