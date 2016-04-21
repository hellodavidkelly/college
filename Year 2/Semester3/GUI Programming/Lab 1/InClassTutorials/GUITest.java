import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;


public class GUITest extends JFrame {



	public static void main(String[] args) {

		GUITest myProg = new GUITest();

	}


	public GUITest() {

		super("Luke's Frame");

		JPanel loginPanel = new JPanel();

		JLabel myFirstLabel = new JLabel("Username: ");

		JTextField myFirstField = new JTextField(10);

		JButton loginButton = new JButton("Submit");

		loginPanel.add(myFirstLabel);

		loginPanel.add(myFirstField);

		loginPanel.add(loginButton);


		getContentPane().add(loginPanel);



		setSize(300,400);

		setVisible(true);

		setResizable(false);

		setLocation(100,200);

	}


}