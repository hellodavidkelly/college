import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

public class InClassGUIExampleG2 extends JFrame {

	JButton goButton = new JButton("Go");
	JPanel goButtonPanel = new JPanel();

	public InClassGUIExampleG2() {

		//Set the title of the Frame, alternative is setTitle("First Java GUI");
		super("First Java GUI");

		//Set the size of the Frame
		setSize(430,380);

		//Set the location of the Frame inside the main window

		setLocation(100,300);

		//Make it NOT resizable

		setResizable(false);


		//Add a Button to the Panel

		goButtonPanel.add(goButton);

		//Add the Panel to the content pane of the Frame

		getContentPane().add(goButtonPanel);

		//You MUST make the JFrame visible if you want to see it


		setVisible(true);


	}


	public static void main(String[] args) {

		InClassGUIExampleG2 myFrame = new InClassGUIExampleG2();


	}


}