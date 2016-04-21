package lab2.part2;

public class NumFactoryTest {

		public static void main(String [] args){
			String list1 = new String("1 2 3 4 5 6 7 8 9");
			String list2 = new String("1.1 2.2 3.3 4.4 5.5 6.6 7.7 8.8 9.9");
			String list3 = new String("FATHERCHRISTMAS");
			
			NumberFactory nFactory = new NumberFactory();
			
			nFactory.getNumberList(list1).display();
			System.out.println("");
			
			NumberList numberList2 = nFactory.getNumberList(list2);
			numberList2.display();
			System.out.println("");
			System.out.println("Sum of list 2: "+ numberList2.sum());
			
			System.out.println("");
			NumberList numberList3 = nFactory.getNumberList(list3);
			numberList3.display();
		}
}
