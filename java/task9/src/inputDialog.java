import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class inputDialog extends JFrame implements ActionListener 
{
	JButton button = new JButton("Start");
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JFrame frame = new JFrame();
	JLabel label = new JLabel("The text you entered was..");

	public static void main(String[] args) 
	{
		inputDialog output = new inputDialog();
	}

	inputDialog() 
	{
		super("Input Dialog");
		Container c = getContentPane();
		button.addActionListener(this);
		panel1.add(label);
		panel2.add(button);
		c.add(panel1);
		c.add(panel2);
		c.setLayout(new FlowLayout());

		setSize(250, 110);
		setVisible(true);
		setResizable(false);
		setLocation(100,200);


	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == button) 
		{
		String str = JOptionPane.showInputDialog(frame, "Input: ", "Enter Text Here");
			
			if(str != null) 
			{
				label.setText(str);
				frame.setLocation(40,40);
			}
			
			else 
			{
				label.setText("You entered no text.");
			}
		}
	}
	
}