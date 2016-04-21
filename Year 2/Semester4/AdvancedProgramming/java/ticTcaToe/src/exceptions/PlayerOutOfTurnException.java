package exceptions;

import javax.swing.JOptionPane;

public class PlayerOutOfTurnException extends Exception
{
	 
	public PlayerOutOfTurnException(String message1, String plr)
	{
		super(message1);
		JOptionPane.showMessageDialog(null, "It is player "+plr+"'s turn..... wait!!");

	}

}

