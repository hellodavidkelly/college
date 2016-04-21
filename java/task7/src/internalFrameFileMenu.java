import javax.swing.*;

public class internalFrameFileMenu extends JFrame
{
	JFrame frame1 = new JFrame();
	JDesktopPane desktop = new JDesktopPane();
	JInternalFrame internalFrame = new JInternalFrame("My First Internal Frame", true, true, true, true);
	JMenuBar firstMenu = new JMenuBar();
	JMenu file = new JMenu("File", true);
	
	JMenuItem newItem = new JMenuItem("New");
	JMenuItem save = new JMenuItem("Save");
	JMenuItem close = new JMenuItem("Close");
	
	public static void main(String[] args) 
	{
		internalFrameFileMenu intFrame = new internalFrameFileMenu();
	}
	
	public internalFrameFileMenu()
	{		
		file.add(newItem);
		file.add(save);
		file.add(close);
		firstMenu.add(file);

		internalFrame.setJMenuBar(firstMenu);
		internalFrame.setSize(640,480);
		internalFrame.setVisible(true);
		internalFrame.setLocation(10,10);
		internalFrame.setResizable(false);
		
		desktop.add(internalFrame);
		frame1.add(desktop);
		frame1.setSize(1000,700);
		frame1.setVisible(true);
		
	}

}