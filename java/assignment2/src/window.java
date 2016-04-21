import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class window extends JFrame implements ActionListener
{
	JFrame frame1 = new JFrame();
	JMenuBar firstMenu = new JMenuBar();
	JMenu select = new JMenu("Select", true);
	JMenuItem mouseEvent = new JMenuItem("Mouse Event", KeyEvent.VK_M);
	JMenuItem game = new JMenuItem("Game", KeyEvent.VK_G);
	JMenuItem exit = new JMenuItem("Exit", KeyEvent.VK_E);
	///////////////
	JInternalFrame mouse; //new JInternalFrame();
	JDesktopPane pane = new JDesktopPane();
	Container c = getContentPane();
	
	public static void main(String[] args) 
	{
		window file = new window();	
		file.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public window()
	{
		super("Menu");
		
		frame1.setJMenuBar(firstMenu);
		firstMenu.add(select);
		select.add(mouseEvent);
		select.add(game);
		select.add(exit);
		select.setMnemonic(KeyEvent.VK_S);
		
		mouseEvent.addActionListener(this);
		game.addActionListener(this);
		exit.addActionListener(this);

		mouseEvent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M , ActionEvent.CTRL_MASK));
		game.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G , ActionEvent.CTRL_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E , ActionEvent.CTRL_MASK));

		frame1.setContentPane(pane);
		frame1.setVisible(true);
		frame1.setSize(900,900);
		frame1.setLocation(100,50);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==mouseEvent)
		{
			pane.add(new mouseEvent());
		}
		
		else if(e.getSource()==game)
		{
			pane.add(new game());
		}
		
		else if(e.getSource()==exit)
		{
			System.exit(0);
		}
		
	}
}

