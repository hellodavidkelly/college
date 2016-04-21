package com.raeside.family;

public class Person 
{
	
	private String firstName;
	private String familyName;
	
	Person(String firstName, String familyName) 
	{
		this.firstName = firstName;
		this.familyName = familyName;
		
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public String getFamilyName() 
	{		
		return familyName;
	}

}
