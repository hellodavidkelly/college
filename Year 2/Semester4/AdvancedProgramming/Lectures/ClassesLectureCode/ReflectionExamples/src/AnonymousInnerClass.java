import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnonymousInnerClass extends JFrame {


 public static void main(String[] args) {
  final JButton button1;
  AnonymousInnerClass GUI = new AnonymousInnerClass();
  button1 = new JButton("Say Hello");
  GUI.getContentPane().setLayout(new FlowLayout());
  GUI.getContentPane().add(button1);
  button1.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent e) {
     System.out.println("Hello");
     button1.setText("Hello");
    }
  });
  GUI.setSize(300,300);
  GUI.setVisible(true);
 }
}
