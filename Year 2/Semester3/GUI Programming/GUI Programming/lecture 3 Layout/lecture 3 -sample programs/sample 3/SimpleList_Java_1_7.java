import javax.swing.*;
import java.awt.*;

class SimpleList_Java_1_7 extends JFrame {

  	public SimpleList_Java_1_7() {

	super("An Example of a Simple List");

	Container c = getContentPane();

	String choices[] = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus","Neptune", "Pluto"};

	JList<String> myList = new JList<String>(choices);
	JScrollPane pane = new JScrollPane(myList);

	myList.addItem(choices[0]);

    c.add(pane);
   	setSize(400,300);
    setVisible(true);
  }


  public static void main(String[] args){
	  SimpleList_Java_1_7 myList = new SimpleList_Java_1_7();
  }

}
