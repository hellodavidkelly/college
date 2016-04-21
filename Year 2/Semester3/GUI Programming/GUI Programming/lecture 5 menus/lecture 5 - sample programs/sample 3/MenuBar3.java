import javax.swing.*;
import java.awt.*;

public class MenuBar3 extends JFrame{

public MenuBar3(){

super("Menu With Items");

JMenuBar mb = new JMenuBar();


JMenu fileMenu = new JMenu("File", false);
JMenu helpMenu = new JMenu("Help", true);

JMenuItem newMenuItem = new JMenuItem("new");
fileMenu.add(newMenuItem);
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

MenuBar3 myMenuBar = new MenuBar3();


}



}