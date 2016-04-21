import javax.swing.*;

public class internalFrame extends JFrame 
{
	JFrame frame1 = new JFrame();
	JDesktopPane desktop = new JDesktopPane();
	JInternalFrame internalFrame = new JInternalFrame("My First Internal Frame", true, true, true, true);
	
	public static void main(String[] args) 
	{
		internalFrame intFrame = new internalFrame();
	}
	
	public internalFrame()
	{		
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
