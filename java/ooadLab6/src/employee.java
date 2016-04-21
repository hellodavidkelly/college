
public class employee 
{

private String name;	
private int empNumber;
private String address;
private int phoneNum;
	
	/////SETS
	public void setName(String t)
	{
		name = t;
	}

	public void setEmpNumber(int e)
	{
		empNumber = e;
	}
	
	public void setAddress(String a)
	{
		address = a;
	}
	
	public void setPhoneNum(int p)
	{
		phoneNum = p;
	}
	
	/////GETS
	public String getName()
	{
		return name;
	}
	
	public int getEmpNumber()
	{
		return empNumber;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public int getPhoneNum()
	{
		return phoneNum;
	}
	
	public void display()
	{
		System.out.println ("");
		System.out.println ("Name"+"\t\t\tAddress"+"\t\t\t\t\tTelephone Number");
		System.out.println (name+"\t\t"+address+"\t\t"+phoneNum);
		System.out.println ("");
	}
}
