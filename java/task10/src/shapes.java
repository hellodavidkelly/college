import javax.swing.*;

public class shapes 
{
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("3 Shapes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		threeShapes s = new threeShapes();
		
		frame.add(s);
		frame.setSize(700,750);
		frame.setVisible(true);
	}

}
