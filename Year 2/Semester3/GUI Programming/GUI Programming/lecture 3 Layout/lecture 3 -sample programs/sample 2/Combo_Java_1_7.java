import javax.swing.*;
import java.awt.*;

class Combo_Java_1_7 extends JFrame {

  	Combo_Java_1_7() {
	super("Combo Example");

	Container c = getContentPane();
	JPanel panel = new JPanel();

	String choices[] = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus","Neptune", "Pluto"};

	JComboBox<String> combo1 = new JComboBox<String>();
    //inline
    JComboBox<String> combo2 = new JComboBox<String>(choices);

	// loop construct
	// populating an array using a loop
	// start finish increment value
	for (int i=0;i<choices.length;i++) {
      	combo1.addItem (choices[i]);
    	}

	combo2.setEditable(true);
    combo2.setMaximumRowCount(4);
    panel.add(combo1);
    panel.add(combo2);
  	c.add(panel);
   	setSize(400,300);
    setVisible(true);
  }


  public static void main(String[] args){
	  Combo_Java_1_7 myCombo = new Combo_Java_1_7();

   }

}
