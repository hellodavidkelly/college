import javax.swing.*;
import java.awt.*;

class RadioGroup extends JFrame {

  	RadioGroup() {

	super("An Example of a Radio Button Application");

	Container c = getContentPane();
	JPanel panel = new JPanel();

	ButtonGroup group = new ButtonGroup();

	JRadioButton bold = new JRadioButton("Bold");
	JRadioButton plain = new JRadioButton("Plain",true);

    panel.add(bold);
	panel.add(plain);
	c.add(panel);




   	setSize(400,300);
    setVisible(true);

    group.add(bold);
	group.add(plain);
  }


  public static void main(String[] args){
	  RadioGroup  myRadio  = new RadioGroup ();

   }

}
