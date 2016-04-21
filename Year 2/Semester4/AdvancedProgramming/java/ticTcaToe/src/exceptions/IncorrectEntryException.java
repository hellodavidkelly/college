package exceptions;

import javax.swing.JOptionPane;

public class IncorrectEntryException extends Exception
{
 
	public IncorrectEntryException(String message1)
	{
		super(message1);
		JOptionPane.showMessageDialog(null, "You Must Enter Either 'X' or 'O' In The TextField");

	}
}
