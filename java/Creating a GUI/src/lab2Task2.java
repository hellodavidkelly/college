
import javax.swing.*;

import java.awt.*;

public class lab2Task2 extends JFrame 
{

	public static void main(String[] args) 
	{

		lab2Task2 firstProg = new lab2Task2();
		
		firstProg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	

	}

	public lab2Task2()
	{
		
		super ("First Java GUI Window");

		setSize(440,380);

		setVisible(true);

		setResizable(false);

		setLocation(100,300);
	}
	
}
