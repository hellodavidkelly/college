import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class correctAnswer extends JFrame implements ItemListener
{
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JLabel question = new JLabel("What is the capital of Ireland?");
	JLabel result = new JLabel();
	JRadioButton opt1 = new JRadioButton("Cork");
	JRadioButton opt2 = new JRadioButton("Dublin");
	JRadioButton opt3 = new JRadioButton("Tralee");
	JRadioButton opt4 = new JRadioButton("Donegal");
	Font fontStyleOne = new Font("Helvetica", Font.PLAIN, 30);
	Container c = getContentPane();
	ButtonGroup group = new ButtonGroup();
	
	public static void main(String[] args) 
	{
		correctAnswer capital = new correctAnswer();
		
		capital.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public correctAnswer()
	{
		super("Capital of Ireland");
		//setLayout(new FlowLayout());
		
		panel1.add(question);
		panel1.add(opt1);
		panel1.add(opt2);
		panel1.add(opt3);
		panel1.add(opt4);
		panel2.add(result);
		
		c.add(panel1);
		c.add(panel2, BorderLayout.SOUTH);
		
		group.add(opt1);
		group.add(opt2);
		group.add(opt3);
		group.add(opt4);
		
		opt1.addItemListener(this);
		opt2.addItemListener(this);
		opt3.addItemListener(this);
		opt4.addItemListener(this);
		
		result.setFont(fontStyleOne);
		
		setVisible(true);
		setSize(500,400);
		setLocation(100,100);
	}
	
	public void itemStateChanged(ItemEvent e)
	{
			if(e.getSource() == opt2)
			{
				result.setText("That's correct");
			}
			else
			{
				result.setText("Sorry, The Capital of Ireland is Dublin");
			}
	}
}
