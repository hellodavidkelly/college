import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;

public class simpleDialogBox extends JFrame
{
	JFrame frame1 = new JFrame();
	
	public static void main(String[] args) 
	{
		simpleDialogBox firstGo = new simpleDialogBox();

	}
	
	simpleDialogBox()
	{
		JOptionPane.showMessageDialog(frame1, "I am coding my latest Java task.");
	}

}
