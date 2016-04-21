import javax.swing.*;
import java.awt.*;

public class ButtonIcon extends JFrame {
  public ButtonIcon() {

	super("Button with Icon");
	Container contentPane = getContentPane();
	JPanel panel = new JPanel();


    	Icon bugIcon = new ImageIcon("bug1.gif");
    	JButton myButton = new JButton("The Bug", bugIcon);
    	panel.add(myButton);

	contentPane.add(panel);


    setSize(300,200);
    setVisible( true );
  }




public static void main(String args [])
{

ButtonIcon myFrame = new ButtonIcon();
myFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

}


}//end of class