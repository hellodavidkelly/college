import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MouseInputListener;

public class mouseEvent extends JInternalFrame implements MouseInputListener
{
	//JInternalFrame taks1frame = new JInternalFrame();
	JPanel panel1 = new JPanel();
	JLabel label1 = new JLabel("Lets get started!");
	Font fontStyleOne = new Font("Helvetica", Font.BOLD, 40);
	
	public static void main(String[] args) 
	{
		mouseEvent task1 = new mouseEvent();
		task1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public mouseEvent()
	{
		super("Mouse",true,true,true,true);
		this.add(panel1);
		panel1.add(label1, BorderLayout.NORTH);
		panel1.setBackground(Color.GRAY);

		label1.setPreferredSize(new Dimension (800,50));
		label1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		label1.addMouseListener(this);
		label1.addMouseMotionListener(this);
		label1.setFont(fontStyleOne);
		
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(900,150);
		this.setLocation(0,0);
	}
	
	public void mouseClicked(MouseEvent e) 
	{
		label1.setText("Mouse Click Event Detected " + ("x") + e.getX() + ", " + ("y") + e.getY());
	}
	
	public void mousePressed(MouseEvent e) 
	{
		label1.setText("Mouse Pressed Event Detected");		
	}
	
	public void mouseReleased(MouseEvent e) 
	{
		label1.setText("Mouse Released Event Detected");			
	}
	
	public void mouseEntered(MouseEvent e) 
	{
		label1.setText("Mouse Entered Event Detected");		
	}

	public void mouseExited(MouseEvent e) 
	{
		label1.setText("Mouse Exit Event Detected");		
	}

	public void mouseDragged(MouseEvent e) 
	{
		label1.setText("Mouse Dragged Event Detected");			
	}

	public void mouseMoved(MouseEvent e) 
	{
		label1.setText("Mouse Move Event Detected");		
	}
}
