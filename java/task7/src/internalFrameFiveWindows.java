import javax.swing.*;

public class internalFrameFiveWindows extends JFrame 
{
	JFrame frame1 = new JFrame();
	JDesktopPane desktop = new JDesktopPane();

	public static void main(String[] args) 
	{
		internalFrameFiveWindows intFrame = new internalFrameFiveWindows();
	}
	
	
	public internalFrameFiveWindows()
	{	
	
		for(int i=0;i<=4;i++)
		{
			JInternalFrame internalFrame = new JInternalFrame("My Internal Frame " + (i+1), true, true, true, true);
		
			internalFrame.setSize(600,600);
			internalFrame.setVisible(true);
			internalFrame.setLocation(i*10,i*10);
			internalFrame.setResizable(false);
			
			desktop.add(internalFrame);
		}
		

		frame1.add(desktop);
		frame1.setSize(800,800);
		frame1.setVisible(true);

	}

}
