import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonAction extends JFrame implements ActionListener {

  JPanel buttonPanel = new JPanel();
  JButton sayHello,sayBye;

  public ButtonAction() {

	sayHello = new JButton("Say Hello");
	sayBye = new JButton("Say Bye");

	buttonPanel.add(sayHello);
	buttonPanel.add(sayBye);

	sayHello.addActionListener(this);
	sayBye.addActionListener(this);


	getContentPane().add(buttonPanel);

	setSize(300,300);
	setVisible(true);

  }

  public static void main(String[] args) {

	  new ButtonAction();
  }

  public void actionPerformed(ActionEvent e) {

	if(e.getSource()==sayHello) {
	  System.out.println("Hi");
    }
    else if(e.getSource()==sayBye) {
	  System.out.println("Bye");

	}
  }





}