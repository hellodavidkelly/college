import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.MouseInputListener;

public class mouseEventLabel extends JFrame implements MouseInputListener
{
	JFrame frame1 = new JFrame();
	JPanel panel1 = new JPanel();
	JLabel label1 = new JLabel();
	Font fontStyleOne = new Font("Arial", Font.BOLD, 30);

	
	public static void main(String[] args) 
	{
		mouseEventLabel eventLabel = new mouseEventLabel();
		eventLabel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public mouseEventLabel()
	{
		frame1.add(panel1, BorderLayout.CENTER);
		panel1.add(label1, BorderLayout.CENTER);
		panel1.setBackground(Color.GREEN);
		frame1.addMouseListener(this);
		frame1.addMouseMotionListener(this);
		
		label1.setFont(fontStyleOne);
		
		frame1.setVisible(true);
		frame1.setResizable(false);
		frame1.setSize(600,500);
		frame1.setLocation(100,200);
	}
	
	public void mouseClicked(MouseEvent e) 
	{
		label1.setText("Mouse Click");
	}
	
	public void mousePressed(MouseEvent e) 
	{
		label1.setText("Mouse Pressed");		
	}
	
	public void mouseReleased(MouseEvent e) 
	{
		label1.setText("Mouse Released");			
	}
	
	public void mouseEntered(MouseEvent e) 
	{
		label1.setText("Mouse Entered");
		
	}

	public void mouseExited(MouseEvent e) 
	{
		label1.setText("Mouse Exit");		
	}

	public void mouseDragged(MouseEvent e) 
	{
		label1.setText("Mouse Dragged");			
	}

	public void mouseMoved(MouseEvent e) 
	{
		label1.setText("Mouse Move");			
	}
}
