import java.awt.event.*;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;


public class AnonymousInnerClass extends JFrame {
	
	public static void main(String[] args) {
		JButton button1;
		AnonymousInnerClass GUI = new AnonymousInnerClass();
		button1 = new JButton("Say Hello");
		GUI.getContentPane().setLayout(new FlowLayout());
		GUI.getContentPane().add(button1);
		button1.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			 System.out.println("Hello");
		  }
	    });
		GUI.setSize(300,300);
		GUI.setVisible(true);
	}
}
