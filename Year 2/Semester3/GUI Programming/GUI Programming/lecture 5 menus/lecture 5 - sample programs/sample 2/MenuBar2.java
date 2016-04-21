import javax.swing.*;
import java.awt.*;

public class MenuBar2 extends JFrame{

public MenuBar2(){

	super("My First Menu Bar");

	JMenuBar mb = new JMenuBar();


	JMenu fileMenu = new JMenu("File", false);
	JMenu helpMenu = new JMenu("Help", true);
	mb.add(fileMenu);
	mb.add(helpMenu);

	setJMenuBar(mb);

	setSize(300, 200);
	setVisible(true);
}


public static void main (String []  args){

	MenuBar2 myMenuBar = new MenuBar2();


}



}