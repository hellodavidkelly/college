import javax.swing.*;
import java.awt.*;

public class GUIThread extends JFrame implements Runnable
{
	String message;
	
	JLabel label = new JLabel("Please Wait");
	JPanel panel = new JPanel();
	Container c = getContentPane();
	
	
	public static void main(String[] args)
	{

	}

	public GUIThread(String x)
	{
		message=x;
		panel.add(label);
		c.add(panel);
		
		setVisible(true);
		setSize(500,500);
		setLocation(100,100);
	}

	
	public void run() 
	{
		try
		{
			Thread.sleep((long)10000);
		}
		catch(InterruptedException e){}	
		label.setText(message);
	}
}