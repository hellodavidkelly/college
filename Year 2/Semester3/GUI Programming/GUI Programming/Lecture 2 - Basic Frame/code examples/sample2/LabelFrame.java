import javax.swing.*;
import java.awt.*;

public class LabelFrame extends JFrame {
  public LabelFrame() {

	super("My Panel");
	Container contentPane = getContentPane();
	JPanel panel = new JPanel();


    // Create and add a JLabel
    JLabel plainLabel = new JLabel("Plain Small Label");
    panel.add(plainLabel);

    // Create a 2nd JLabel
    JLabel fancyLabel = new JLabel("Fancy Big Label");

    // Instantiate a Font object to use for the label
    Font fancyFont = new Font("Serif", Font.BOLD | Font.ITALIC, 32);

    // Associate the font with the label
    fancyLabel.setFont(fancyFont);

    // Create an Icon
    Icon tigerIcon = new ImageIcon("bug1.gif");

    // Place the Icon in the label
    fancyLabel.setIcon(tigerIcon);

    // Align the text to the right of the Icon
    fancyLabel.setHorizontalAlignment(JLabel.RIGHT);


    // Add to panel
    panel.add(fancyLabel);

    // Add to the content pane
	contentPane.add(panel);

	//set the frame properties
    setSize(600,400);
    setVisible( true );
  }




public static void main(String args [])
{

LabelFrame myFrame = new LabelFrame();
myFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

}


}//end of class