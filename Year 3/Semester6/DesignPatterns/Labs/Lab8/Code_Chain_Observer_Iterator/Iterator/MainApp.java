import java.io.*;
import java.util.*;

class MainApp
{
	private Vector data;

	public MainApp()
	{
		data = new Vector();

		data.addElement("Alan");
		data.addElement("Eimear");
		data.addElement("Conor");
		data.addElement("Andrew");
		data.addElement("Joanne");
		data.addElement("David");
		data.addElement("John");
		data.addElement("Martin");
	}

	public void filterNames()
	{
		Filter filter = new Filter(data.elements(), "J");

		while(filter.hasMoreElements())
		{
			String s = (String)filter.nextElement();
			System.out.println(s);
		}
	}

	public static void main(String[] args)
	{
		MainApp app = new MainApp();

		app.filterNames();
	}
}