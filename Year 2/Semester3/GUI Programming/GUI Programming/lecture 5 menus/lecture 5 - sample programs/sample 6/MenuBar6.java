import javax.swing.*;
import java.awt.*;

public class MenuBar6 extends JFrame{

public MenuBar6(){

super("Menu Items with Icons");

JMenuItem jmiNew, jmiOpen;

JMenuBar mb = new JMenuBar();


JMenu fileMenu = new JMenu("File", false);
JMenu helpMenu = new JMenu("Help", true);


JMenu softwareHelpSubMenu = new JMenu("Software");
JMenu hardwareHelpSubMenu = new JMenu("Hardware");

helpMenu.add(softwareHelpSubMenu);
helpMenu.add(hardwareHelpSubMenu);
helpMenu.add(new JCheckBoxMenuItem("Check it"));

softwareHelpSubMenu.add(new JMenuItem("Unix"));
softwareHelpSubMenu.add(new JMenuItem("NT"));
softwareHelpSubMenu.add(new JMenuItem("Win95"));

hardwareHelpSubMenu.add(new JMenuItem("Soundcards"));
hardwareHelpSubMenu.add(new JMenuItem("Monitors"));
hardwareHelpSubMenu.add(new JMenuItem("Network cards"));

fileMenu.add(jmiNew = new JMenuItem("New"));
fileMenu.add(jmiOpen = new JMenuItem("Open"));


jmiNew.setIcon(new ImageIcon("images/new.gif"));
jmiOpen.setIcon(new ImageIcon("images/open.gif"));

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

MenuBar6 myMenuBar = new MenuBar6();


}



}