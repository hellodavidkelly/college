import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

/*
 * InternalFrameDemo.java
 *
 */

public class InternalFrameDemo1 extends JFrame {



    public InternalFrameDemo1() {

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

        setContentPane(desktop); //important as it allows us to add items to the desktop
        setSize(640,480);
        setVisible(true);

    }


    public static void main(String[] args) {

        InternalFrameDemo1 frame = new InternalFrameDemo1();

    }
}
