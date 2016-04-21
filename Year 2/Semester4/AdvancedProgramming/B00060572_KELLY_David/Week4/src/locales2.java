import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class locales2 extends JFrame implements ActionListener
{

//GUI Components///////////////////
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	Container c = getContentPane();
	JTextArea text1 = new JTextArea(5,40);
	JScrollPane scroll = new JScrollPane(text1);
	String[] language = {"English","French"};
	JComboBox combo = new JComboBox(language);
	Locale[] availableLocales = Calendar.getAvailableLocales();
	JButton getLocales;
//Program Resources////////////////
	ResourceBundle res;
	Locale loc;
	

	public static void main(String[] args)
	{
		locales2 gui = new locales2();
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public locales2()
	{
		super ("Get Locales");
		loc = new Locale("fr");
		res = res.getBundle("ProgramResource", loc);
		getLocales = new JButton("Get Locales");
		
		getLocales.addActionListener(this);
		combo.addActionListener(this);
		panel1.add(getLocales);
		panel1.add(combo);
		panel2.add(scroll);
		c.add(panel1, BorderLayout.NORTH);
		c.add(panel2);	
		
//GUI Properties///////////////////			
	    setLocation(100,100);
		setSize(600,200);
		setVisible(true);
	}
	
	public void getLanguage()
	{
		if(combo.getSelectedIndex()==0)
		{
			loc = new Locale("en");
			getLocales.setText("Get Locales");
		}
		
		else if(combo.getSelectedIndex()==1)
		{
			loc = new Locale("fr");
			getLocales.setText(res.getString("getLocales"));
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{		
		if(e.getSource()==combo)
		{
			getLanguage();
		}
		
		if(e.getSource()==getLocales)
		{
			for(int i=0;i<availableLocales.length;i++)
			{
				text1.append(availableLocales[i].getDisplayName(loc)+"\n");
			}
		}
	}

}
