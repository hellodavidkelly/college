import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class dropDown extends JFrame implements ItemListener
{

	String[] options = {"Lion", "Monkey", "Elephant", "Kangaroo", "Polar Bear", "Penguin", "Ostrich"};
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JComboBox animals = new JComboBox(options);
	JLabel chosenAnimal = new JLabel();
	Font fontStyleOne = new Font("Helvetica", Font.PLAIN, 100);
	Container c = getContentPane();
	
	public static void main(String[] args) 
	{
		dropDown selectAnimal = new dropDown();
		
		selectAnimal.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public dropDown()
	{
		super ("dropdown Animal menu");
		//setLayout(new FlowLayout());
		
		panel1.add(animals);
		panel2.add(chosenAnimal);
		c.add(panel1);
		c.add(panel2, BorderLayout.SOUTH);
		animals.addItemListener(this);
		chosenAnimal.setFont(fontStyleOne);

		setVisible(true);
		setSize(500,300);
		setLocation(400,400);

	}
	
	public void itemStateChanged(ItemEvent e)
	{
			chosenAnimal.setText("" + animals.getSelectedItem());
	}
}
