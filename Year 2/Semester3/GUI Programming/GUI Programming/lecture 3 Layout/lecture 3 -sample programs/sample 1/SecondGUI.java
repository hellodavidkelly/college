import javax.swing.*;

public class SecondGUI extends JFrame {

	public static void main(String[] args) {

		SecondGUI myProg = new SecondGUI();

	}


	public SecondGUI() {

		JTextField textField = new JTextField(10);
		JPanel fieldPanel = new JPanel();

		fieldPanel.add(textField);

		getContentPane().add(fieldPanel);


		setSize(300,300);
		setVisible(true);

	}


}