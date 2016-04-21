import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIEvents extends JFrame implements ActionListener {


	JButton button1, button2;
	JPanel buttonPanel;

	public static void main(String[] args) {

		GUIEvents myGUI = new GUIEvents();
	}

	public GUIEvents() {

		button1 = new JButton("Testing");
		button2 = new JButton("Testing again");
		buttonPanel = new JPanel();

		button1.addActionListener(this);
		button2.addActionListener(this);

		Container c = getContentPane();
		buttonPanel.add(button1);
		buttonPanel.add(button2);

		c.add(buttonPanel);

		setSize(300,300);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		System.out.println("Hello, I'm listening");

		if(e.getSource()==button1) {
			button1.setText("1 2 3");
		}
		else {
			button2.setText("Yay");
		}



	}



}