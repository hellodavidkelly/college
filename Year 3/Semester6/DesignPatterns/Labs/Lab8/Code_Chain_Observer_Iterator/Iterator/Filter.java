import java.util.*;

class Filter implements Enumeration
{
	private Enumeration data;
	private String filter;
	private String element;

	public Filter(Enumeration data, String filter)
	{
		this.filter = filter;
		this.data = data;
		element = null;
	}

	public Object nextElement()
	{
		if (element != null)
			return element;
		else
			throw new NoSuchElementException();
	}

	public boolean hasMoreElements()
	{
		boolean found = false;
		while(data.hasMoreElements() && !found)
		{
			element = (String)data.nextElement();
			found = element.startsWith(filter);
		}
		if (! found)
			element = null;
		return found;
	}

}


