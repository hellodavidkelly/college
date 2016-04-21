import javax.swing.*;
import java.awt.*;

class SimpleList extends JFrame {

  	public SimpleList() {

	super("An Example of a Simple List");

	Container c = getContentPane();

	String choices[] = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus","Neptune", "Pluto"};

	JList myList = new JList(choices);
	JScrollPane pane = new JScrollPane(myList);

    c.add(pane);
   	setSize(400,300);
    setVisible(true);
  }


  public static void main(String[] args){
	  SimpleList myList = new SimpleList();

   }

}
