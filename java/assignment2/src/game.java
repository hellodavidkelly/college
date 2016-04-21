import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.EventObject;

public class game extends JInternalFrame implements MouseInputListener, ItemListener, ActionListener
{
	//JFrame frame1 = new JFrame();
	JMenuBar menu = new JMenuBar();
	JMenu option = new JMenu("Options");
	JMenuItem reset = new JMenuItem("Reset", KeyEvent.VK_R);
	JPanel panel1 = new JPanel(new GridLayout(3,10));
	JPanel panel2 = new JPanel(new GridLayout(1,3));
	JLabel[] label = new JLabel[30];
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel("Next Number: 1");
	String[] options = {"English","French","German"};
	JComboBox language = new JComboBox(options);
	Font fontStyleOne = new Font("Helvetica", Font.BOLD, 20);
	Font fontStyleTwo = new Font("Bauhaus 93", Font.BOLD, 20);
	String ranString;
	int c=0;
	int keeper=2;
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	String clickedString;
	String[] numbers = {"ONE","TWO", "THREE", "FOUR", "FIVE","SIX", "SEVEN", "EIGHT", "NINE", "TEN",
						"UN", "DEUX", "TROIS", "QUATRE", "SINQ", "SIX", "SEPT", "HUIT", "NEUF", "DIX",
						"EINS", "ZWEI", "DREI", "VIER", "FUNF", "SECHS", "SIEBEN", "AUCHT", "NEUN", "ZEHN"};
	
	String[] englishNum = {"ONE","TWO","THREE","FOUR","FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN"};	
	String[] frenchNum = {"UN", "DEUX", "TROIS", "QUATRE", "SINQ", "SIX", "SEPT", "HUIT", "NEUF", "DIX"};
	String[] germanNum = {"EINS", "ZWEI", "DREI", "VIER", "FUNF", "SECHS", "SIEBEN", "AUCHT", "NEUN", "ZEHN"};
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	public static void main(String[] args) 
	{
		game playgame = new game();
	}
	
	public game()
	{
		super("Counting Game",true,true,true,true);
		
		setup();
		
		option.add(reset);
		menu.add(option);
		label2.setFont(fontStyleTwo);
		label3.setFont(fontStyleTwo);
		this.add(menu, BorderLayout.NORTH);
		this.add(panel1, BorderLayout.CENTER);
		this.add(panel2, BorderLayout.SOUTH);
		panel2.add(language, BorderLayout.WEST);
		panel2.add(label2, BorderLayout.CENTER);
		panel2.add(label3, BorderLayout.EAST);
		reset.addActionListener(this);
		this.setVisible(true);
		this.setSize(900,300);
		this.setLocation(0,150);
		this.setResizable(false);
	}
	
	public void setup()
	{
		for(int i=0;i<=29;i++)
		{
			label[i] = new JLabel();
			label[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			label[i].setFont(fontStyleOne);
			label[i].addMouseListener(this);
			panel1.add(label[i], BorderLayout.NORTH);
		}
		
		language.addItemListener(this);
	}

	public void StringCheck(int languageSelect, String ranString)
	{
		if(language.getSelectedIndex()==0)
		{
			compareEng(englishNum, clickedString);
			c++;
			keeper++;
			
			if(clickedString.equals("TEN"))
			{
				c=0;
				keeper=1;
			}
		}
		
		else if(language.getSelectedIndex()==1)
		{
			compareFre(frenchNum, clickedString);
			c++;
			keeper++;
			
			if(clickedString.equals("DIX"))
			{
				c=0;
				keeper=1;

			}
		}
		
		else if(language.getSelectedIndex()==2)
		{
			compareGer(germanNum, clickedString);
			c++;
			keeper++;
			
			if(clickedString.equals("ZEHN"))
			{
				c=0;
				keeper=1;
			}
		}
	}
	 
	 public void compareEng(String[] englishNum, String clickedString)
	 {
		if(englishNum[c].equals(clickedString))
		{
			label2.setText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tCorrect");
			label3.setText("Next Number: " + keeper);
		}
		
		else
		{
			c=-1;
			label2.setText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tStart Again");
			keeper=1;
			label3.setText("Next Number: " + keeper);
		}

	 }
	 
	 public void compareFre(String[] frenchNum, String clickedString)
	 {
		if(frenchNum[c].equals(clickedString))
		{
			label2.setText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tCorrect");
			label3.setText("Next Number: " + keeper);
		}
		
		else
		{
			c=-1;
			label2.setText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tStart Again");
			keeper=1;
			label3.setText("Next Number: " + keeper);
		}

	 }
	 
	 public void compareGer(String[] germanNum, String clickedString)
	 {
		if(germanNum[c].equals(clickedString))
		{
			label2.setText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tCorrect");
			label3.setText("Next Number: " + keeper);
		}
		
		else
		{
			c=-1;
			label2.setText("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tStart Again");
			keeper=1;
			label3.setText("Next Number: " + keeper);
		}

	 }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	public void mouseMoved(MouseEvent e) 
	{
		
	}

	
	public void itemStateChanged(ItemEvent e) 
	{
		
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public void mouseEntered(MouseEvent e) 
	{
		if(e.getSource() instanceof JLabel)
		{
		int ran = (int) (Math.random()*30);
		ranString= numbers[ran];
		((JLabel)e.getSource()).setText(ranString);
		}
	}

	
	public void mouseExited(MouseEvent e) 
	{
		if(e.getSource() instanceof JLabel)
		{
		((JLabel)e.getSource()).setText("");		
		}
	}

	public void mouseClicked(MouseEvent e)
	{
		if(e.getSource() instanceof JLabel)
		{
		clickedString = ((JLabel)e.getSource()).getText();
		StringCheck(language.getSelectedIndex(), ranString);
		}
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public void mousePressed(MouseEvent e) 
	{

	}

	public void mouseReleased(MouseEvent e) 
	{
	
	}
	
	public void mouseDragged(MouseEvent e) 
	{

	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==reset)
		{
			c=0;
			label2.setText("\t\t\t\t\t\t\t\t\t\t\t\tGame Reset");
			keeper=1;
			label3.setText("Next Number: " + keeper);
			keeper++;
		}	
	}
	

}
