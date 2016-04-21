import javax.swing.*;
import java.awt.*;

public class MenuBar extends JFrame{

public MenuBar(){

	super("My First Menu Bar");
	JMenuBar mb = new JMenuBar();
	setJMenuBar(mb);

	setSize(300, 200);
	setVisible(true);
}


public static void main (String []  args){

	MenuBar myMenuBar = new MenuBar();


}



}