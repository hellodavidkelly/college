import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class checkBox extends JFrame
{
	JPanel panel1 = new JPanel();
	String[] animals = {"Lion", "Monkey", "Elephant", "Kangaroo", "Polar Bear", "Penguin", "Ostrich"};
	JCheckBox animalList = new JCheckBox(animals[0]);
	JCheckBox animalList1 = new JCheckBox(animals[1]);
	JCheckBox animalList2 = new JCheckBox(animals[2]);
	JCheckBox animalList3 = new JCheckBox(animals[3]);
	JCheckBox animalList4 = new JCheckBox(animals[4]);
	JCheckBox animalList5 = new JCheckBox(animals[5]);
	JCheckBox animalList6 = new JCheckBox(animals[6]);


	Container c = getContentPane();
	
	
	public static void main(String[] args) 
	{
		checkBox checkAnimals = new checkBox();
		
		checkAnimals.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public checkBox()
	{
		super("Animals");
		//setLayout(new FlowLayout());
		
		panel1.add(animalList);
		panel1.add(animalList1);
		panel1.add(animalList2);
		panel1.add(animalList3);
		panel1.add(animalList4);
		panel1.add(animalList5);
		panel1.add(animalList6);
		
		c.add(panel1);
		
		setVisible(true);
		setSize(100,200);
		setLocation(100,100);
		setResizable(false);
	}

}
