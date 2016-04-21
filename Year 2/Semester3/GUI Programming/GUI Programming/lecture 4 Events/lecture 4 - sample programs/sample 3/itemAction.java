//Subject:	Complex Action Listener
//Author:  	Daniel Mc Sweeney
//Date:		17th October 2002


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class itemAction extends JFrame implements ItemListener {

JCheckBox box1, box2;

itemAction(){

super("Complex Action Test");

Container c = getContentPane();

//create the panel and buttons
JPanel panel = new JPanel();
box1 = new JCheckBox("Action 1");
box2 = new JCheckBox("Action 2");


//add the action listeners
box1.addItemListener(this);
box2.addItemListener(this);

//add the buttons to the panel
panel.add(box1);
panel.add(box2);


//add the panel to the frame and display it
c.add(panel);
setSize(400,300);
show();

}//end of constructor




	public static void main(String args[]){

		itemAction testcomplexAction = new itemAction();

	}



	public void itemStateChanged(ItemEvent e)  {
			String message = "";
			System.out.println("Hello");

			//Object source = e.getItemSelectable();


			if (e.getItemSelectable() == box1 ) message = "you clicked on the first box - Action 1";
			else message = "you clicked on the second box - Action 2";


        	JOptionPane.showMessageDialog(null, message, "Lights....Camera", JOptionPane.ERROR_MESSAGE);
	}





} // end of class