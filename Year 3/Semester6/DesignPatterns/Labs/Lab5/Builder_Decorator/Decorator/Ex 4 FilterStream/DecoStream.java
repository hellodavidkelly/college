import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

public class DecoStream extends JxFrame {
   JTextArea ltext, rtext;

   public DecoStream()  {
      super("Decorate Input Stream");
      setGUI();

      File fl = new File("note.txt");

      String s   = readNormal(fl);
      ltext.setText (s);

      s = readFilter(fl);
      rtext.setText (s);

      setSize(new Dimension(300, 200));
      setVisible(true);
   }
   //-----------------------------
   private String readNormal(File fl) {
      FileInputStream fread = null;
      String s = "";
      try {
         fread = new FileInputStream(fl);
         byte b[] = new byte[1000];
         int length = fread.read (b);
         fread.close ();
         s = new String(b, 0, length);
      }
      catch(FileNotFoundException e){}
      catch(IOException ie){}
     return s;
   }
   //-----------------------------
   private String readFilter(File fl) {
      FileInputStream fread = null;
      String s = "";
      try {
         fread = new FileInputStream(fl);
         FileFilter ff = new FileFilter(fread);
         s = ff.readLine ();
         ff.close ();
      }
      catch(FileNotFoundException e){}
      catch(IOException ie){}

    return s;
   }
   //-----------------------------
   private void setGUI() {
      JPanel jp = new JPanel();
      getContentPane().add(jp);
      jp.setLayout (new GridLayout(1,2));
      ltext = new JTextArea(30,3);
      rtext = new JTextArea(30,3);
      ltext.setBorder(new BevelBorder(BevelBorder.LOWERED));
      rtext.setBorder(new BevelBorder(BevelBorder.LOWERED));

      jp.add(ltext);
      jp.add(rtext);
      ltext.setLineWrap (true);
      ltext.setWrapStyleWord (true);
      rtext.setLineWrap (true);
      rtext.setWrapStyleWord (true);
   }
   //-----------------------------
   static public void main(String[] argv) {
      new DecoStream();
   }
}
