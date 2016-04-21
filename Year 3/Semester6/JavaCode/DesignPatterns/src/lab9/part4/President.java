package lab9.part4;

import java.util.Vector;

import lab4.part1.SolarSystemSunLimitException;
import lab4.part1.Sun;

public class President {
	
	private static President firstInstance = null;
	private int age;
	private String name;
	
	private President(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	public static President createPresident(int age, String name){
		
		if(firstInstance==null){
			firstInstance = new President(age, name);
		}
		return firstInstance;
	}
	
	public void getAge(){
		System.out.println(age);
	}	
	
	public void getName(){
		System.out.println(name);
	}
}
