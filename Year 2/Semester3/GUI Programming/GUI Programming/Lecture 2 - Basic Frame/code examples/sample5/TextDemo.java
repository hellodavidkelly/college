import javax.swing.*;
import java.awt.*;

public class TextDemo extends JFrame {
  public TextDemo() {

	super("Button with Icon");
	Container contentPane = getContentPane();
	JPanel panel = new JPanel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();

    // Instantiate a new TextField
	JTextField tf = new JTextField();

	// Instantiate a new TextArea
	JTextArea ta = new JTextArea();

	// Initialize the text of each
	tf.setText("TextField");
	ta.setText("JTextArea\n Allows Multiple Lines");

	//add the text field to the panel
	panel.add(tf);

	//add a scrollpane containing a text field to the panel
	JScrollPane myPane = new JScrollPane(ta);
	panel.add(myPane);


	//panel.add(new JScrollPane(ta));


	//add the panel to the content pane
	contentPane.add(panel);

	//set the windoe properties
    setSize(300,200);
    setVisible( true );
  }




public static void main(String args [])
{

TextDemo myFrame = new TextDemo();
myFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

}


}//end of class