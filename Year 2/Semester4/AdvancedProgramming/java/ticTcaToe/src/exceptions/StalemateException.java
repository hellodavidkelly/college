package exceptions;

import javax.swing.JOptionPane;

public class StalemateException extends Exception
{
 
	public StalemateException(String message1)
	{
		super(message1);
		JOptionPane.showMessageDialog(null, message1);
	}

}
