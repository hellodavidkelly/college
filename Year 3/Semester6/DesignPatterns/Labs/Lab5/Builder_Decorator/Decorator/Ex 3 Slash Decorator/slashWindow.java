import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;


public class slashWindow extends JxFrame
   implements ActionListener
{
   JButton CButton, DButton, Quit;
   public slashWindow()
   {
      super ("Deco Button");
      JPanel jp = new JPanel();

      getContentPane().add(jp);

      jp.add( new CoolDecorator(
		      CButton = new JButton("Cbutton")));

	  jp.add( new SlashDecorator(new CoolDecorator(
		      DButton = new JButton("Dbutton"))));


      jp.add(Quit = new JButton("Quit"));
      Quit.addActionListener(this);
      setSize(new Dimension(200,100));

      setVisible(true);
      Quit.requestFocus();
   }
   public void actionPerformed(ActionEvent e)
   {
      System.exit(0);
   }
   static public void main(String argv[])
   {
      new slashWindow();
   }
}
