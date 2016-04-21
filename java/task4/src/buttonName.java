import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class buttonName extends JFrame implements ActionListener
{
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	Icon firstIcon = new ImageIcon("/Users/mjrbronchaus/Desktop/College/java/task4/images/favicon.png");
	JButton b1 = new JButton(firstIcon);
	JButton b2 = new JButton("JENSON");
	JButton b3 = new JButton("BUTTON");
	JLabel buttonClicked = new JLabel();
	Font fontStyleOne = new Font("mistral", Font.PLAIN, 20);
	Container c = getContentPane();

	
	public static void main(String[] args) 
	{
		buttonName changeLabel = new buttonName();
		
		changeLabel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}

	
	public buttonName()
	{
		super("Three Buttons");
		//setLayout(new FlowLayout());
		
		panel1.add(b1);
		panel1.add(b2);
		panel1.add(b3);
		panel2.add(buttonClicked, BorderLayout.SOUTH);
		c.add(panel1);
		c.add(panel2, BorderLayout.SOUTH);

		b2.setFont(fontStyleOne);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		setVisible(true);
		setSize(500,300);
		setLocation(200,100);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			buttonClicked.setText("BUTTON 1");
		}
		
		else if(e.getSource()==b2)
		{
			buttonClicked.setText("BUTTON 2");		
		}
		
		else
		{
			buttonClicked.setText("BUTTON 3");
		}
	}
}
