import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class UndoCmd extends JxFrame
   implements ActionListener {

   cmdButton btRed, btBlue, btUndo;
   undoCommand u_cmd;
   blueCommand blue_command;
   redCommand red_command;

   public UndoCmd() {
      super("Undo Commands");
      JPanel jp = new JPanel();
      getContentPane().add(jp);
      jp.setLayout(new BorderLayout());
      JPanel bp = new JPanel();
      jp.add("South", bp);
      paintPanel cp = new paintPanel();
      jp.add("Center", cp);

      btRed = new cmdButton("Red", this);
      red_command = new redCommand(cp);
      btRed.setCommand (red_command);
      btRed.addActionListener (this);

      btBlue = new cmdButton("Blue", this);
      blue_command = new blueCommand(cp);
      btBlue.setCommand (blue_command);
      btBlue.addActionListener (this);

      btUndo = new cmdButton("Undo", this);
      u_cmd = new undoCommand();
      btUndo.setCommand (u_cmd);
      btUndo.addActionListener (this);

      bp.add(btRed);
      bp.add(btUndo);
      bp.add(btBlue);
      setSize(new Dimension(300, 300));
      setVisible(true);
      blue_command.setPanel (cp);
      //red_command.setPanel (cp);

   }
   public void actionPerformed(ActionEvent e) {
      CommandHolder cmdh = (CommandHolder)e.getSource ();
      Command cmd = cmdh.getCommand ();
      u_cmd.add (cmd);  //add to list
      cmd.Execute ();   //and execute
   }

   static public void main(String argv[]) {
      new UndoCmd();
   }
   //============================
   public class paintPanel extends JPanel {
      public void paint(Graphics g) {
       Dimension sz = getSize();
       g.setColor(Color.lightGray );
       g.fillRect (0, 0, sz.width , sz.height );
       red_command.draw(g);
       blue_command.draw(g);
    }
   }
}
