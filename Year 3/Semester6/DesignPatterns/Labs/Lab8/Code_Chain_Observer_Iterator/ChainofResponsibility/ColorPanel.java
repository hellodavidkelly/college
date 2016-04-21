import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class ColorPanel extends JPanel implements Chain
{
	private Chain nextChain = null;

	public ColorPanel()
	{
		setBorder(new TitledBorder("Color Changes"));
	}
	public void addChain(Chain c)
	{
		nextChain = c;
	}

	public void sendToChain(String mesg)
	{
		// Try to convert string to
		// color object
		Color c = getColor(mesg);

		if (c != null)
		{
			setBackground(c);
	    	repaint();
		}
		else
		{
			if (nextChain != null)
				nextChain.sendToChain(mesg);
		}
	}

	public Chain getChain()
	{
		return nextChain;
    }

	private Color getColor(String mesg)
	{
		String lmesg = mesg.toLowerCase();
		Color c = null;

		if (lmesg.equals("red"))
			c = Color.red;
		else if (lmesg.equals("blue"))
			c = Color.blue;
		else if (lmesg.equals("green"))
			c= Color.green;
		return c;
    }
}
