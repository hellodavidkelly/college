//Subject:	Complex Action Listener
//Author:  	Daniel Mc Sweeney
//Date:		17th October 2002


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class complexAction extends JFrame implements ActionListener {

complexAction(){

super("Complex Action Test");

Container c = getContentPane();

//create the panel and buttons
JPanel panel = new JPanel();
JButton button = new JButton("Action 1");
JButton button2 = new JButton("Action 2");


//add the action listeners
button.addActionListener(this);
button2.addActionListener(this);

//add the buttons to the panel
panel.add(button);
panel.add(button2);


//add the panel to the frame and display it
c.add(panel);
setSize(400,300);
setVisible(true);

}//end of constructor




	public static void main(String args[]){

		complexAction testcomplexAction = new complexAction();

	}


	public void actionPerformed(ActionEvent e) {
			String message = "";

			if (e.getActionCommand().equals("Action 1") ) message = "you clicked on the first button - Action 1";
			else message = "you clicked on the second button - Action 2";
				System.out.println(e.toString());

        	JOptionPane.showMessageDialog(null, message, "Lights....Camera", JOptionPane.ERROR_MESSAGE);
	}





} // end of class