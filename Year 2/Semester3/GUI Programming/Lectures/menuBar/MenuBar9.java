import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MenuBar9 extends JFrame implements ActionListener{

public MenuBar9(){

super("Event Handling");

JMenuItem jmiNew, jmiOpen;


//create the menu bar
JMenuBar mb = new JMenuBar();


//create the file menu and help menu
JMenu fileMenu = new JMenu("File", false);
JMenu helpMenu = new JMenu("Help", true);


//create a Software and HardWare menu items
JMenu softwareHelpSubMenu = new JMenu("Software");
JMenu hardwareHelpSubMenu = new JMenu("Hardware");


//add the software and Hardware manu itemsn to the Help menu item (creating sub menu items)
helpMenu.add(softwareHelpSubMenu);
helpMenu.add(hardwareHelpSubMenu);

//add a checkbox item to the help menu item
helpMenu.add(new JCheckBoxMenuItem("Check it"));


//create a sub menu from the software sub menu
softwareHelpSubMenu.add(new JMenuItem("Unix"));
softwareHelpSubMenu.add(new JMenuItem("NT"));
softwareHelpSubMenu.add(new JMenuItem("Win95"));

//create a sub menu from the hardware sub menu
hardwareHelpSubMenu.add(new JMenuItem("Soundcards"));
hardwareHelpSubMenu.add(new JMenuItem("Monitors"));
hardwareHelpSubMenu.add(new JMenuItem("Network cards"));

//Add New and Open menu items to the file menu
fileMenu.add(jmiNew = new JMenuItem("New"));
fileMenu.add(jmiOpen = new JMenuItem("Open"));

//add icons to the New and Open Menu Items
jmiNew.setIcon(new ImageIcon("images/new.gif"));
jmiOpen.setIcon(new ImageIcon("images/open.gif"));


//Set mnemonic and acclerator keys for menu items
helpMenu.setMnemonic('H');
fileMenu.setMnemonic('F');
jmiNew.setMnemonic('N');
jmiOpen.setMnemonic('O');
jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O , ActionEvent.CTRL_MASK));

//Add a seperator to the file menu
fileMenu.addSeparator();

//Add print and exit menu items to the file menu
fileMenu.add(new JMenuItem("print"));
fileMenu.add(new JMenuItem("exit"));


//Add actionlisteners top New and Open
jmiNew.addActionListener(this);
jmiOpen.addActionListener(this);


mb.add(fileMenu);
mb.add(helpMenu);

setJMenuBar(mb);

setSize(300, 200);
setVisible(true);
}


public static void main (String []  args){

MenuBar9 myMenuBar = new MenuBar9();


}


public void actionPerformed(ActionEvent e)
{

String message = "";

//lets check that a menu created the event
if (e.getSource() instanceof JMenuItem){

if (e.getActionCommand().equals("New")) message = "The New Item was selected";
else if (e.getActionCommand().equals("Open")) message = "The Open Item was selected";

JOptionPane.showMessageDialog(null,message, "The Menu was clicked", JOptionPane.PLAIN_MESSAGE);

}

}




}//end of class


