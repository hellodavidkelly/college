import java.awt.*;
import javax.swing.*;
import java.lang.reflect.*;


public class ClassInvestigater extends JFrame
{

	JPanel panel = new JPanel();
	JTextArea ta = new JTextArea(5,20);
	Container c = getContentPane();
	
	public static void main(String[] args) 
	{
		ClassInvestigater gui = new ClassInvestigater();
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void reflect()
	{
		try 
		{
	        Class cls = Class.forName("CollegeHelper");

	        Field f[] = cls.getDeclaredFields();
	        Method m[] = cls.getDeclaredMethods();
	        
	        for (int i=0;i<f.length;i++) 
	        {
	           ta.append(f[i].getName()+"\n");
	        }
	    
	        for (int j=0;j<m.length;j++)
	        {
		         ta.append(m[j].getName()+"\n");
	        }
		} 
	     catch (Exception e) 
	     {
	        System.out.println("Exception: " + e);
	     }
	}
	
	public ClassInvestigater()
	{
		super("Class Investigater");
		panel.add(ta);
		c.add(panel);
		
		reflect();
		
		setVisible(true);
		setSize(400,150);
		setLocation(450,300);
	}
}
