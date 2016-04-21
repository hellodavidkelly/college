import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class responceDialogBox extends JFrame implements ActionListener
{
	JFrame frame1 = new JFrame("Dinner Option");
	JPanel panel1 = new JPanel();
	JButton m1 = new JButton("Meal 1");
	JButton m2 = new JButton("Meal 2");
	JButton m3 = new JButton("Meal 3");

	public static void main(String[] args) 
	{
		responceDialogBox firstGo = new responceDialogBox();
	}
	
	
	responceDialogBox()
	{		
		m1.addActionListener(this);
		m2.addActionListener(this);
		m3.addActionListener(this);

		
		panel1.add(m1);
		panel1.add(m2);
		panel1.add(m3);
		
		frame1.add(panel1);
		frame1.setVisible(true);
		frame1.setSize(400,200);
		frame1.setResizable(false);

	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==m1||e.getSource()==m2||e.getSource()==m3) 
		{
			Object[] options = {"Ok", "Cancel"};
			int n = JOptionPane.showOptionDialog(frame1,
												"Ok to continue",
												"Confirmation",
												JOptionPane.YES_NO_OPTION, 
												JOptionPane.QUESTION_MESSAGE, 
												null, 
												options,  
												options[1] );
		 }
	}
	 
}
