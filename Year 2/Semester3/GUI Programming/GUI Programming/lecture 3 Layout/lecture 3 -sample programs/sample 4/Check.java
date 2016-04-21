import javax.swing.*;
import java.awt.*;

class Check extends JFrame {

  	Check() {

	super("An Example of a Check Box Application");

	Container c = getContentPane();
	JPanel panel = new JPanel();
	JCheckBox bold = new JCheckBox("bold");
	JCheckBox plain = new JCheckBox("plain",true);
	panel.add(bold);
	panel.add(plain);

    c.add(panel);
   	setSize(400,300);
    show();
  }


  public static void main(String[] args){
	  Check  myCheck  = new Check ();

   }

}
