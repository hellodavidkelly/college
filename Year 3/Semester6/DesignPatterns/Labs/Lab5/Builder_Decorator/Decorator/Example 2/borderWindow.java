import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;


public class borderWindow extends JxFrame
   implements ActionListener
{
   JButton Quit, Cbutton, Dbutton;
   public borderWindow()
   {
      super ("Deco Button");
      JPanel jp = new JPanel();

      getContentPane().add(jp);

      jp.add( new CoolDecorator(Cbutton = new JButton("Cbutton")));
      jp.add( new CoolDecorator(Dbutton = new JButton("Dbutton")));

		//jp.add(Cbutton = new JButton("Cbutton"));
		//jp.add(Dbutton = new JButton("Dbutton"));

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
      new borderWindow();
   }
}
