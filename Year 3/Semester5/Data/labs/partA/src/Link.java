
class Link
{
	public char dData; //Data item
	public Link next; //Next link in list
	
	public Link(char dd)
	{
		dData = dd;
	}
	
	public void displayLink()
	{
		System.out.print(dData + "");
	}
}