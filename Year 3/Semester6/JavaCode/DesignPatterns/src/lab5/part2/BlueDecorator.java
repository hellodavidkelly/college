package lab5.part2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

public class BlueDecorator extends Decorator {
    boolean mouse_over;    //true when mouse over button
    JComponent thisComp;

    public BlueDecorator(JComponent c) {
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
        //super.paint(g);      //first draw the parent button
        //if the mouse is not over the button
        //erase the borders
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(15));
        
        if (mouse_over) {
            Dimension d = super.getSize();
            g.setColor(Color.BLUE);
            g.drawRect(0, 0, d.width, d.height);
            g2.drawLine(d.width-1, 0, d.width-1, d.height-1);
            g2.drawLine(1, d.height-1, d.width-1, d.height-1);

        }
    }
}
