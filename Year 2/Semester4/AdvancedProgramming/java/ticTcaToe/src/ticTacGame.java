import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import exceptions.IncorrectEntryException;
import exceptions.PlayerOutOfTurnException;
import exceptions.StalemateException;
//importing resources


public class ticTacGame extends JFrame implements ActionListener
{
	//declaring public variables
	JPanel topPanel = new JPanel(new GridLayout(3,3));
	JPanel bottomPanel = new JPanel(new BorderLayout());
	JLabel msg = new JLabel("Your Turn X");
	Container c = getContentPane();
	JTextField[] t = new JTextField[9];
	JButton restart = new JButton("Restart");
	JButton check = new JButton("Check Winner");
	Boolean turn = (true);
	Font newStyle = new Font("Helvetica", Font.BOLD, 35);
	String input;
	String[] m = new String[9];
	int moves = 0;
	Boolean didIWin= (false);
	
	//main method
	public static void main(String[] args) 
	{
		ticTacGame gameGUI = new ticTacGame();
		gameGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//constructor
	public ticTacGame ()
	{
		super("Tic Tac Toe");

		//Adding TextFields to Panel
		for(int i=0;i<9;i++)
		{
			t[i] = new JTextField();
			t[i].addActionListener(this);
			t[i].setFont(newStyle);
			topPanel.add(t[i]);
		}
		
		//adding listeners
		restart.addActionListener(this);
		check.addActionListener(this);
		
		//adding components to bottom panel
		bottomPanel.add(msg, BorderLayout.NORTH);
		bottomPanel.add(restart, BorderLayout.WEST);
		bottomPanel.add(check, BorderLayout.EAST);

		c.add(topPanel, BorderLayout.NORTH);
		c.add(bottomPanel, BorderLayout.SOUTH);
		
		//GUI Properties
		setSize(300,220);
		setVisible(true);
		setLocation(100,100);
		setResizable(false);
	}
	
	//the main part of the game also declaring the exception classes
	public void logic(ActionEvent c) throws IncorrectEntryException, PlayerOutOfTurnException
	{
		//for loop to retrieve values in the JTextFields so I can compare them
		//c.getSource()==t[j]) finds out which textfield I am in
		for(int j=0;j<9;j++)
		{
			if(c.getSource()==t[j])
			{
				//input is a string variable that stores the values
				input = t[j].getText();
				//turn is a boolean var that checks I am using the correct letter X or O?
				if(turn==false&&input.equalsIgnoreCase("x"))
				{
					throw new PlayerOutOfTurnException("It is Player O's Turn", "O");
				}
				else if(turn==true&&input.equalsIgnoreCase("x"))
				{
					//X is always the first player
					//setEditable turns off the textfield from further changes
					t[j].setEditable(false);
					msg.setText("Next Player's Turn");
					//Switch the boolean var to allow the next user to play
					turn=!turn;
					//escape from the for loop
					moves++;
					break;
				}
				
				input = t[j].getText();
				if(turn==true&&input.equalsIgnoreCase("o"))
				{
					throw new PlayerOutOfTurnException("It is Player X's Turn", "X");
				}
				else if(turn==false&&input.equalsIgnoreCase("o"))
				{
					t[j].setEditable(false);
					msg.setText("Next Player's Turn");
					turn=!turn;
					moves++;
					break;
				}	
				//If none of the options above re chosen it means that the user entered an invalid character
				//Notify them and dont allow it to be used
				else
				{
					throw new IncorrectEntryException("You input "+input+".......you must enter either an 'X' or an 'O'");
				}
			}
		}
	}
	
	//If the user wishes to restart or play again after finishing
	public void restart()
	{
		for(int y=0;y<9;y++)
		{
			//resets all the textfields to be used again
			t[y].setEditable(true);
			//clears out the old values
			t[y].setText(null);
			//changes the color of the font back to black
			t[y].setForeground(Color.BLACK);
			msg.setText("Your Turn X");
			//Makes sure that X is always player 1
			turn=true;
			didIWin=false;
			moves=0;
		}
	}
	
	public void confirm() throws StalemateException
	{
		for(int i=0;i<9;i++)
		{
			m[i]=t[i].getText();
		}
			//Check for a winner with a simple algorithm
			//8 ways to win the game
			if(m[0].equalsIgnoreCase(m[1])&&m[1].equalsIgnoreCase(m[2]))
			{
				didIWin=true;
				msg.setText("Player "+m[0]+" Is the Winner!");
				t[0].setForeground(Color.GREEN);
				t[1].setForeground(Color.GREEN);
				t[2].setForeground(Color.GREEN);
			}
			if(m[3].equalsIgnoreCase(m[4])&&m[4].equalsIgnoreCase(m[5]))
			{
				didIWin=true;
				msg.setText("Player "+m[3]+" Is the Winner!");
				t[3].setForeground(Color.GREEN);
				t[4].setForeground(Color.GREEN);
				t[5].setForeground(Color.GREEN);
			}
			if(m[6].equalsIgnoreCase(m[7])&&m[7].equalsIgnoreCase(m[8]))
			{
				
				didIWin=true;
				msg.setText("Player "+m[6]+" Is the Winner!");
				t[6].setForeground(Color.GREEN);
				t[7].setForeground(Color.GREEN);
				t[8].setForeground(Color.GREEN);
			}
			if(m[0].equalsIgnoreCase(m[3])&&m[3].equalsIgnoreCase(m[6]))
			{
				didIWin=true;
				msg.setText("Player "+m[0]+" Is the Winner!");
				t[0].setForeground(Color.GREEN);
				t[3].setForeground(Color.GREEN);
				t[6].setForeground(Color.GREEN);
			}
			if(m[1].equalsIgnoreCase(m[4])&&m[4].equalsIgnoreCase(m[7]))
			{
				didIWin=true;
				msg.setText("Player "+m[1]+" Is the Winner!");
				t[1].setForeground(Color.GREEN);
				t[4].setForeground(Color.GREEN);
				t[7].setForeground(Color.GREEN);
			}
			if(m[2].equalsIgnoreCase(m[5])&&m[5].equalsIgnoreCase(m[8]))
			{
				didIWin=true;
				msg.setText("Player "+m[2]+" Is the Winner!");
				t[2].setForeground(Color.GREEN);
				t[5].setForeground(Color.GREEN);
				t[8].setForeground(Color.GREEN);
			}
			if(m[0].equalsIgnoreCase(m[4])&&m[4].equalsIgnoreCase(m[8]))
			{
				didIWin=true;
				msg.setText("Player "+m[0]+" Is the Winner!");
				t[0].setForeground(Color.GREEN);
				t[4].setForeground(Color.GREEN);
				t[8].setForeground(Color.GREEN);
			}
			if(m[2].equalsIgnoreCase(m[4])&&m[4].equalsIgnoreCase(m[6]))
			{
				didIWin=true;
				msg.setText("Player "+m[2]+" Is the Winner!");
				t[2].setForeground(Color.GREEN);
				t[4].setForeground(Color.GREEN);
				t[6].setForeground(Color.GREEN);
			}
			
			//Because empty textfields still have null values that match they are considered equal
			//But they have just yet to be used
			if(msg.getText().equals("Player  Is the Winner!"))
			{
				for(int k=0;k<9;k++)
				{
				msg.setText("No winner yet");
				t[k].setForeground(Color.BLACK);
				}
			}
			else
			{
				//Checks all the textfields have a value
				if(moves==9&&didIWin==false)
				{
					throw new StalemateException("There is no winner this time");
				}
			}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try 
		{
			logic(e);
		} 
		catch(PlayerOutOfTurnException b)
		{
			//b.printStackTrace();
		}
		catch(IncorrectEntryException a) 
		{
			//a.printStackTrace();
		}

		
		if(e.getSource()==restart)
		{
			restart();	
		}
		
		if(e.getSource()==check)
		{
			try 
			{
				confirm();
			} catch (StalemateException c) 
			{
				//c.printStackTrace();
			}
		}
	}	
}
