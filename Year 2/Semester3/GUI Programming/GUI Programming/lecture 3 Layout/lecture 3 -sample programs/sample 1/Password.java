import javax.swing.*;
import java.awt.*;

class Password extends JFrame {

  	Password() {
	super("password Example");

	Container c = getContentPane();
	JPanel panel = new JPanel();
    	JPasswordField pass1 = new JPasswordField(20);
    	JPasswordField pass2 = new JPasswordField(20);
    	pass2.setEchoChar ('?');
    	panel.add(pass1);
    	panel.add(pass2);
   		//show();
   		c.add(panel);
   		setSize(400,300);
   		setVisible(true);

  }


  public static void main(String[] args){
	  Password passdemo = new Password();

   }

}
