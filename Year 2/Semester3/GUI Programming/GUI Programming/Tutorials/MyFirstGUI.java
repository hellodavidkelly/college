import javax.swing.*;
import java.awt.*;

public class MyFirstGUI extends JFrame {

  JButton button1 = new JButton("BANGBINGBONGBANG!");
  JButton button2 = new JButton("BONG!");
  JPanel buttonPanel = new JPanel();


  public static void main(String[] args) {
	new MyFirstGUI();

  }


  public MyFirstGUI() {
	  Container c = getContentPane();

	buttonPanel.add(button1);
	buttonPanel.add(button2);

	c.add(buttonPanel);

	setSize(200,200);
	setVisible(true);

  }


}