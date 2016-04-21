

public interface Enumeration
{
	public boolean hasMoreElements();
	public Object nextElement();
}



public Enumeration elements();



Enumeration e = vector.elements();
while(e.hasMoreElements())
{
	String name = (String)e.nextElement();
	System.out.println(s);
}