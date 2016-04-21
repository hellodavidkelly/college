package lab7.part3;


import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class Gremlin extends JPanel {
    URL image = this.getClass().getResource("gremlin.png");
    ImageIcon icon = new ImageIcon(image);
    final int W = 50, H = 30;
    final int tableft = 0, tabheight=4, tabwidth=20, tabslant=3;
    JLabel label;
    
    public Gremlin(ImageIcon icon) {
    	this.icon = icon;
    	label = new JLabel(icon);
    }
    
    public void draw(Graphics g, int tx, int ty, String name) {
    	icon.paintIcon(getParent(), g, tx, ty);
    	g.drawString(name, tx, ty + H+15);  //title
        Polygon poly = new Polygon();
        poly.addPoint (tx+tableft,ty);
        poly.addPoint (tx+tableft+tabslant, ty-tabheight);
        poly.addPoint (tx+tabwidth-tabslant, ty-tabheight);
        poly.addPoint (tx+tabwidth, ty);
    }
}
