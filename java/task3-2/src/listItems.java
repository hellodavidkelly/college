import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class listItems extends JFrame
{
	JPanel panel1 = new JPanel();
	String[] animals = {"Lion", "Monkey", "Elephant", "Kangaroo", "Polar Bear", "Penguin", "Ostrich"};
	JList animalList = new JList((animals));
	Container c = getContentPane();
	
	
	public static void main(String[] args) 
	{
		listItems listAnimals = new listItems();
		
		listAnimals.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public listItems()
	{
		super("Animals");
		//setLayout(new FlowLayout());
		
		panel1.add(animalList);
		
		c.add(panel1);
				
		setVisible(true);
		setSize(100,200);
		setLocation(100,100);
		setResizable(false);
	}

}
