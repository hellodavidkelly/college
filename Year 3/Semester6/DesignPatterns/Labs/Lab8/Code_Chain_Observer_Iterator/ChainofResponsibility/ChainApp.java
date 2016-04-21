import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class ChainApp extends JxFrame
{

	private Sender sender;
	private ColorPanel colpanel;
	private Calculator calc;
	private Unknown unknown;

	public ChainApp()
	{
		super("Chain demo");

		sender = new Sender();
		colpanel = new ColorPanel();
		calc = new Calculator();
		unknown = new Unknown();

		Container c = getContentPane();

		c.setLayout(new GridLayout(2,2));
		c.add(sender);
		c.add(colpanel);
		c.add(calc);
		c.add(unknown);

		sender.addChain(colpanel);
		colpanel.addChain(calc);
		calc.addChain(unknown);
		unknown.addChain(null);


		setSize(500,500);
		show();
	}

	public static void main(String[] args)
	{
		ChainApp capp = new ChainApp();
	}
}