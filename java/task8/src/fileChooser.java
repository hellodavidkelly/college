import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class fileChooser extends JFrame //implements ActionListener
{
	JFrame frame1 = new JFrame();
	JPanel panel1 = new JPanel();
	//JMenuBar firstMenu = new JMenuBar();
	//JMenu file = new JMenu("File", true);
	//JMenuItem chooseFile = new JMenuItem("Choose File...");
	JFileChooser fc = new JFileChooser();
	
	public static void main(String[] args) 
	{
		fileChooser chooser = new fileChooser();
		
		chooser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public fileChooser()
	{		
		super("whatever");
		
		//frame1.setJMenuBar(firstMenu);
		//firstMenu.add(file);
		//file.add(chooseFile);
		//chooseFile.addActionListener(this);
		frame1.add(panel1);
		panel1.setBackground(Color.GRAY);
		frame1.setVisible(true);
		frame1.setSize(800,800);
		frame1.setLocation(100,100);
		
		//launching of the filechooser
		fc.showOpenDialog(null);
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	}
	
	/*public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==chooseFile)
		{
		//Were I had the fileChooser if it were in a menuItem	
		}
		
	}*/
}
