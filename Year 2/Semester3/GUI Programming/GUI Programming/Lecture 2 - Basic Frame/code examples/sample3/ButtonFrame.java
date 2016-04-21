import javax.swing.*;
import java.awt.*;

public class ButtonFrame extends JFrame {
  public ButtonFrame() {

	super("Button Sample");
	Container contentPane = getContentPane();
	JPanel panel = new JPanel();


    	JButton myButton = new JButton("The Bug");
    	panel.add(myButton);

	contentPane.add(panel);


    setSize(300,200);
    setVisible( true );
  }




public static void main(String args [])
{

ButtonFrame myFrame = new ButtonFrame();
myFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

}


}//end of class