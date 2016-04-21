import javax.swing.*;
import java.awt.*;

public class MenuBar4 extends JFrame{

public MenuBar4(){

super("Menu With Sub Menu Items");

JMenuBar mb = new JMenuBar();


JMenu fileMenu = new JMenu("File", false);
JMenu helpMenu = new JMenu("Help", true);


JMenu softwareHelpSubMenu = new JMenu("Software");
JMenu hardwareHelpSubMenu = new JMenu("Hardware");

helpMenu.add(softwareHelpSubMenu);
helpMenu.add(hardwareHelpSubMenu);

softwareHelpSubMenu.add(new JMenuItem("Unix"));
softwareHelpSubMenu.add(new JMenuItem("NT"));
softwareHelpSubMenu.add(new JMenuItem("Win95"));

hardwareHelpSubMenu.add(new JMenuItem("Soundcards"));
hardwareHelpSubMenu.add(new JMenuItem("Monitors"));
hardwareHelpSubMenu.add(new JMenuItem("Network cards"));

fileMenu.add(new JMenuItem("new"));
fileMenu.add(new JMenuItem("open"));
fileMenu.addSeparator();

fileMenu.add(new JMenuItem("print"));
fileMenu.add(new JMenuItem("exit"));



mb.add(fileMenu);
mb.add(helpMenu);

setJMenuBar(mb);

setSize(300, 200);
setVisible(true);
}


public static void main (String []  args){

MenuBar4 myMenuBar = new MenuBar4();


}



}