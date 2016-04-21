package lab8.part2;

import java.util.Iterator;
import java.util.Vector;

public class TestJavaIterator{


	
	public TestJavaIterator(){

	}
	
	public static void main(String[] args){
		Vector<Animal> vec = new Vector<Animal>();
		Animal alanSheep = new Sheep("Alan");
		Animal barrySheep = new Sheep("Barry");
		Animal carlSheep = new Sheep("Carl");
		Animal daveSheep = new Sheep("Dave");
		Animal eoinSheep = new Sheep("Eoin");
		Animal andyBull = new Bull("Andy");
		Animal brianBull = new Bull("Brian");
		Animal crisBull = new Bull("Cris");
		Animal daraBull = new Bull("Dara");
		Animal eddyBull = new Bull("Eddy");
		
		vec.add(alanSheep);
		vec.add(barrySheep);
		vec.add(carlSheep);
		vec.add(daveSheep);
		vec.add(eoinSheep);
		vec.add(andyBull);
		vec.add(brianBull);
		vec.add(crisBull);
		vec.add(daraBull);
		vec.add(eddyBull);
		
		Iterator<Animal> iterator = vec.iterator();

		
		while(iterator.hasNext()){
			iterator.next().details();
		}
	}

}
