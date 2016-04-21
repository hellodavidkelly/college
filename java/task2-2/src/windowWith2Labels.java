import javax.swing.*;
import java.awt.*;

public class windowWith2Labels extends JFrame
{

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel holder = new JPanel();
	//Creating 2 new panels
	
	JLabel firstLabel = new JLabel("My First Label");
	JLabel secondLabel = new JLabel("My Second Label");
	//Creating 2 new labels
	
	Font fontStyleOne = new Font("Arial", Font.ITALIC, 14);
	Font fontStyleTwo = new Font("Times", Font.BOLD, 12);
	//Creating 2 new font styles
	
	Container c = getContentPane();
	//Creating a Container to add.panels to the JFrame
	
	public static void main(String[] args) 
	{

		windowWith2Labels secondProg = new windowWith2Labels();
		//The program the runs the GUI
		
		secondProg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Operation to close the program on close
	}

	public windowWith2Labels()
	{
		super ("Round Two");
		//Title of the GUI
		
		panel1.add(firstLabel);
		holder.add(panel1);

		panel2.add(secondLabel);
		holder.add(panel2);
		
		c.add(holder);
		
		firstLabel.setFont(fontStyleOne);
		secondLabel.setFont(fontStyleTwo);
		
		setVisible(true);
		setSize(400,400);
		setLocation(100,200);

	}
}
