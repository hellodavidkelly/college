import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Locale;

public class locales extends JFrame implements ActionListener
{
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	Container c = getContentPane();
	JButton but1 = new JButton("List All Locales");
	JTextArea text1 = new JTextArea(5,40);
	JScrollPane scroll = new JScrollPane(text1);
	Locale[] availableLocales = Calendar.getAvailableLocales();
	
	public static void main(String[] args)
	{
		locales gui = new locales();
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public locales()
	{
		super ("Get Locales");
		
		but1.addActionListener(this);
		panel1.add(but1);
		panel2.add(scroll);
		c.add(panel1, BorderLayout.NORTH);
		c.add(panel2);	
		
		
	    setLocation(100,100);
		setSize(600,200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Locale loc = new Locale("en");
		if(e.getSource()==but1)
		{
			for(int i=0;i<availableLocales.length;i++)
			{
				text1.append(availableLocales[i].getDisplayName(loc)+"\n");
			}
		}
	}
}
