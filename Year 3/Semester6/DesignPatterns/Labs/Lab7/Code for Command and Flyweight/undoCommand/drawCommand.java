import java.awt.*;
import java.util.*;
import javax.swing.*;
//parent class for redCommand and blueCommand
public class drawCommand implements Command {
   protected Vector drawList;
   protected int x, y, dx, dy;
   protected Color color;
   protected JPanel p;

   public drawCommand(JPanel pn) {
      drawList = new Vector();
      p = pn;     //save panel we draw on
   }
   //------------------------------------
   public void Execute() {
      drawList.add(new drawData(x, y, dx, dy));
      x += dx;    //increment to next position
      y += dy;
      p.repaint();
   }
   //------------------------------------
   public void unDo() {
      int index = drawList.size() -1;
      //remove last-drawn line from list
      if(index >= 0)  {
         drawData d = (drawData)drawList.elementAt (index);
         drawList.remove (index);
         x = d.getX ();
         y = d.getY ();
      }
      p.repaint();
   }
   //------------------------------------
   public void draw(Graphics g) {
      //draw all remaining lines in list
      //called by panel's paint method
      Dimension sz = p.getSize();
      g.setColor (color);
      for (int i=0; i < drawList.size (); i++) {
         drawData d = (drawData)drawList.elementAt (i);
         g.drawLine (d.getX (), d.getY (),
                     d.getX()+dx, d.getY()+sz.height );
      }
   }
}
