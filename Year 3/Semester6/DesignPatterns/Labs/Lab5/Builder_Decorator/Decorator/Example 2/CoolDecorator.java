import java.awt.*;
import java.awt.event.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
/** This class decorates a CoolButton so that
the borders are invisible when the mouse
is not over the button
*/


public class CoolDecorator extends Decorator {
    boolean mouse_over;    //true when mose over button
    JComponent thisComp;

    public CoolDecorator(JComponent c) {
        super(c);
        mouse_over = false;
        thisComp = this;      //save this component
        //catch mouse movements in inner class
        c.addMouseListener(new MouseAdapter() {
               //set flag when mouse over
               public void mouseEntered(MouseEvent e) {
                       mouse_over = true;
                       thisComp.repaint();
               }
              //clear flag when mouse not over
              public void mouseExited(MouseEvent e) {
                       mouse_over = false;
                       thisComp.repaint();
               }
          });
    }



    //paint the button
    public void paint(Graphics g) {
        super.paint(g);      //first draw the parent button
        //if the mouse is not over the button
        //erase the borders
        if (! mouse_over) {
            Dimension d = super.getSize();
            g.setColor(Color.lightGray);
            g.drawRect(0, 0, d.width-1, d.height-1);
            g.drawLine(d.width-2, 0, d.width-2, d.height-1);
            g.drawLine(0, d.height-2, d.width-2, d.height-2);
        }
    }
}
