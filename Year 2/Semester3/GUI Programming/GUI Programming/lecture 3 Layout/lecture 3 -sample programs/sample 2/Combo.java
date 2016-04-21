import javax.swing.*;
import java.awt.*;

class Combo extends JFrame {

  	Combo() {
	super("Combo Example");

	Container c = getContentPane();
	JPanel panel = new JPanel();

	String choices[] = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus","Neptune", "Pluto"};

	//String myChoice[] = new String[10];


	JComboBox combo1 = new JComboBox();
    //inline
    JComboBox combo2 = new JComboBox(choices);

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
    show();
  }


  public static void main(String[] args){
	  Combo myCombo = new Combo();


   }

}
