import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;

public class LukeFirstGUI extends JFrame {


  public LukeFirstGUI(String s) {

	  super(s);

	  //JPanel componentPanel = new JPanel();
	  JTextField myFirstField = new JTextField(20);


	  JButton myFirstButton = new JButton("Hello this is my label");

	  getContentPane().add(myFirstButton);
	  //componentPanel.add(myFirstField);


	  //add(componentPanel);
	  setSize(300,300);
	  setVisible(true);





  }


  public static void main(String args[]) {

		LukeFirstGUI myGUI1 = new LukeFirstGUI("My Title1");
		LukeFirstGUI myGUI2 = new LukeFirstGUI("My Title2");
		LukeFirstGUI myGUI3 = new LukeFirstGUI("My Title3");
		LukeFirstGUI myGUI4 = new LukeFirstGUI("My Title");
		LukeFirstGUI myGUI5 = new LukeFirstGUI("My Title");
		LukeFirstGUI myGUI6 = new LukeFirstGUI("My Title");
		LukeFirstGUI myGUI7 = new LukeFirstGUI("My Title");
		LukeFirstGUI myGUI8 = new LukeFirstGUI("My Title");
		LukeFirstGUI myGUI9 = new LukeFirstGUI("My Title");
		LukeFirstGUI myGUI10 = new LukeFirstGUI("My Title");
		LukeFirstGUI myGUI11 = new LukeFirstGUI("My Title");
		LukeFirstGUI myGUI12 = new LukeFirstGUI("My Title");
		LukeFirstGUI myGUI13 = new LukeFirstGUI("My Title");
		LukeFirstGUI myGUI14 = new LukeFirstGUI("My Title");



  }



}