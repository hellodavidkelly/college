import java.awt.BorderLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


//Sample GUI that uses resource bundles to internationalize 
public class SimpleButtonGUI extends JFrame {

  ResourceBundle res;

  public SimpleButtonGUI() {

    Locale loc = new Locale("de","DE"); //create Locale for German in Germany

    res = res.getBundle("ProgramResource",loc); //Create resource bundle

    JLabel greetLabel = new JLabel(res.getString("greeting")); //get value for greeting key value

    JButton computeButton = new JButton(res.getString("computeButton")); //button key value

    getContentPane().add(greetLabel);
    getContentPane().add(computeButton,BorderLayout.SOUTH);

    setSize(200,200);
    setVisible(true);
  }

  public static void main(String[] args) {
    SimpleButtonGUI myGui = new SimpleButtonGUI();
  }
}

