import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//In this version, we fully decouple the Commands from
//the men and Button subclasses.
// the Command objects are external classes
//and we pass them copies of the Frame instance
//in their constructor
public class fullCommand extends JxFrame
   implements ActionListener
{
   JMenu mnuFile;
   cmdMenu  mnuOpen, mnuExit;
   cmdButton btnRed;
   JPanel p, jp;
   JxFrame fr;
   fileCommand flc;
   ExitCommand extc;
   RedCommand redc;
   //-----------------------------------------
   public fullCommand()
   {
      super("Frame with external commands");
      fr = this;     //save frame object
      JPanel jp = new JPanel();
      getContentPane().add(jp);
      JMenuBar mbar = new JMenuBar();
      setJMenuBar(mbar);

      mnuFile = new JMenu("File", true);
      mbar.add(mnuFile);

      mnuOpen = new cmdMenu("Open...", this);
      mnuFile.add(mnuOpen);

      mnuOpen.setCommand (new fileCommand(this));
      mnuExit = new cmdMenu("Exit", this);
      mnuExit.setCommand (new ExitCommand());

      mnuFile.add(mnuExit);


      mnuOpen.addActionListener(this);
      mnuExit.addActionListener(this);

      btnRed = new cmdButton("Red", this);
      redc = new RedCommand(this, jp);
      btnRed.setCommand (redc);

      jp.add(btnRed);

      btnRed.addActionListener(this);
      setBounds(100,100,200,100);
      setVisible(true);
   }
   //-----------------------------------------
   public void actionPerformed(ActionEvent e)   {
      CommandHolder obj = (CommandHolder)e.getSource();
      obj.getCommand().Execute();
   }
   //-----------------------------------------
   static public void main(String argv[])
   {
      new fullCommand();
   }
}


