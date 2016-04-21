import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class myCalculatorGUI extends JFrame implements ActionListener
{

	JPanel panel1 = new JPanel(new FlowLayout());
	JPanel panel2 = new JPanel(new FlowLayout());
	JPanel panel3 = new JPanel(new FlowLayout());

	Container c = getContentPane();
	JLabel text = new JLabel("Eneter an Int:");
	JTextField t1 = new JTextField(("0"), 5);
	JTextField t2 = new JTextField(("Result"), 5);
	JButton but1 = new JButton("DOUBLE");
	JButton but2 = new JButton("TRIPLE");
	
	public static void main(String[] args) 
	{
		myCalculatorGUI gui = new myCalculatorGUI();
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	public myCalculatorGUI()
	{
		super ("Calculator");

		but1.addActionListener(this);
		but2.addActionListener(this);
		panel1.add(text);
		panel1.add(t1);
		panel2.add(but1);
		panel2.add(but2);
		panel3.add(t2);		
		c.add(panel1, BorderLayout.WEST);
		c.add(panel2);
		c.add(panel3, BorderLayout.EAST);

		setLocation(100,100);
		setSize(500,100);
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==but1)
			{
				String x = t1.getText();
				int num = Integer.parseInt(x);
				String y = Integer.toString(mathHelper.doubleInt(num));
				t2.setText(y);
			}
	
			else
			{
				String x = t1.getText();
				int num = Integer.parseInt(x);
				String y = Integer.toString(mathHelper.tripleInt(num));
				t2.setText(y);			
			}
		}
		
		catch(NumberFormatException c)
		{
			t2.setText("Enter Int");
		}
	}
}
