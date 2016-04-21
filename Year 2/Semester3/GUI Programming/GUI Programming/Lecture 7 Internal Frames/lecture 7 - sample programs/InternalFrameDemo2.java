import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/*
 * InternalFrameDemo.java
 *
 */

public class InternalFrameDemo2 extends JFrame {



    public InternalFrameDemo2() {

        super("Internal Frame Demo");

		//Set up the GUI.
        JDesktopPane desktop = new JDesktopPane(); //a specialized layered pane
        JInternalFrame innerframe = new JInternalFrame("Internal Window" ,
              										true, //resizable
              										true, //closable
              										true, //maximizable
              										true);//iconifiable

		innerframe.setSize(300,300);
		innerframe.setVisible(true); //necessary as of 1.3
        desktop.add(innerframe);

		innerframe.setJMenuBar(createMenuBar());
        setContentPane(desktop); //important as it allows us to add items to the desktop
        setSize(640,480);
        setVisible(true);

    }

	 protected JMenuBar createMenuBar() {
	        JMenuBar menuBar = new JMenuBar();

	        //Set up the lone menu.
	        JMenu menu = new JMenu("Document");
	        menu.setMnemonic(KeyEvent.VK_D);
	        menuBar.add(menu);

	        //Set up the first menu item.
	        JMenuItem menuItem = new JMenuItem("New");
	        menuItem.setMnemonic(KeyEvent.VK_N);
	        menuItem.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_N, ActionEvent.ALT_MASK));
	        menuItem.setActionCommand("new");
	        menu.add(menuItem);

	        //Set up the second menu item.
	        menuItem = new JMenuItem("Quit");
	        menuItem.setMnemonic(KeyEvent.VK_Q);
	        menuItem.setAccelerator(KeyStroke.getKeyStroke(
	                KeyEvent.VK_Q, ActionEvent.ALT_MASK));
	        menuItem.setActionCommand("quit");
	        menu.add(menuItem);

	        return menuBar;
    }



    public static void main(String[] args) {

        InternalFrameDemo2 frame = new InternalFrameDemo2();

    }
}
