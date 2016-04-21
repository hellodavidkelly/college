import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class helpMenu extends JFrame //implements ActionListener
{
	JFrame frame1 = new JFrame();
	JMenuBar firstMenu = new JMenuBar();
	JMenu help = new JMenu("Help", true);
	Container c = getContentPane();
	
	
	public static void main(String[] args) 
	{
		helpMenu help = new helpMenu();
		help.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public helpMenu()
	{
		super("Menu");
		
		frame1.setJMenuBar(firstMenu);
		firstMenu.add(help);
		
		help.add(new JMenuItem("Help Topics"));
		help.addSeparator();
		help.add(new JMenuItem("Technical Support"));
		help.add(new JMenuItem("Frequently Asked Questions"));
		help.add(new JMenuItem("TextPad on the Web"));
		help.add(new JMenuItem("Update License..."));
		help.add(new JMenuItem("Ordering Information"));
		help.addSeparator();		
		help.add(new JMenuItem("Tip of the Day"));
		help.addSeparator();	;
		help.add(new JMenuItem("About TextPad..."));
		
		frame1.setVisible(true);
		frame1.setSize(300,300);
		frame1.setLocation(100,100);
	}
}
