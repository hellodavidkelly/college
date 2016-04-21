import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class capitalCity extends JFrame
{
	JPanel panel1 = new JPanel();
	JLabel question = new JLabel("What is the capital of Ireland?");
	JRadioButton opt1 = new JRadioButton("Cork", true);
	JRadioButton opt2 = new JRadioButton("Dublin");
	JRadioButton opt3 = new JRadioButton("Tralee");
	JRadioButton opt4 = new JRadioButton("Donegal");
	Container c = getContentPane();
	ButtonGroup group = new ButtonGroup();
	
	public static void main(String[] args) 
	{
		capitalCity capital = new capitalCity();
		
		capital.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public capitalCity()
	{
		super("Capital of Ireland");
		setLayout(new FlowLayout());
		
		panel1.add(question);
		panel1.add(opt1);
		panel1.add(opt2);
		panel1.add(opt3);
		panel1.add(opt4);
		c.add(panel1);
		
		group.add(opt1);
		group.add(opt2);
		group.add(opt3);
		group.add(opt4);
		
		setVisible(true);
		setSize(500,100);
		setLocation(100,100);

	}
}
