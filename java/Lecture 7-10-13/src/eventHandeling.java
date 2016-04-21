import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class eventHandeling extends JFrame implements ActionListener
{

	
	JPanel xPanel, buttonPanel;
	JLabel leftLabel, rightLabel;
	JButton leftButton, rightButton;

	
	public static void main(String[] args) 
	{

		eventHandeling lectureProg = new eventHandeling();
		
		lectureProg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	

		
	}
	
	public eventHandeling()
	{
		//Panels created
		xPanel = new JPanel();
		xPanel.setLayout(new GridLayout(1,2));
		
		buttonPanel = new JPanel();	
		buttonPanel.setLayout(new FlowLayout());
		
		leftButton = new JButton("<");
		xPanel.add(leftButton);
		
		rightButton = new JButton(">");
		xPanel.add(rightButton);
		
		getContentPane().add(xPanel, BorderLayout.SOUTH);
		
		leftLabel = new JLabel("X ");
		buttonPanel.add(leftLabel);
		
		rightLabel = new JLabel("");
		buttonPanel.add(rightLabel);
		
		getContentPane().add(buttonPanel, BorderLayout.CENTER);		
		
		//Add event listener to component
		leftButton.addActionListener(this);
		rightButton.addActionListener(this);
		
		setSize(300,500);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==leftButton)
		{
			System.out.println("Hi I'm lefty and I work");
			
			leftLabel.setText("X");
			rightLabel.setText(" ");
		}
		
		else
		{
			System.out.println("Hi I'm righty and I work");
			leftLabel.setText(" ");
			rightLabel.setText("X");
		}
	}
}
