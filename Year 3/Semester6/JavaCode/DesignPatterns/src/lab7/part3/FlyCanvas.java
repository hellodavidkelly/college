package lab7.part3;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class FlyCanvas extends JxFrame
    implements ActionListener {
    Gremlin gremlin;
    Vector names;
    GremlinFactory fact;
    final int Top = 10, Left = 10;
    final int  W = 40, H = 40;
    final int VSpace = 250, HSpace=250, HCount = 5;
    String selectedName="";

    public FlyCanvas() {
        super("Flyweight Canvas");

        loadNames();
        JButton button = new JButton("Add Gremlin");
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        jp.add(button, BorderLayout.SOUTH);
        getContentPane().add(jp);
        setSize(1800,800);
        button.addActionListener(this);
        setVisible(true);
        repaint();
    }

    private void loadNames() {
        names = new Vector();
        fact = new GremlinFactory();
        names.addElement("Alan");

        selectedName = "";
		repaint();

    }

    public void paint(Graphics g) {
        Gremlin f;
        String name;

        int j = 0;      //count number in row
        int row = Top;  //start in upper left
        int x = Left;

        //go through all the names and folders
        for (int i = 0; i< names.size(); i++) {
            name = (String)names.elementAt(i);
            if (name.equals(selectedName))
                f = fact.getGremlin(true);
            else
                f = fact.getGremlin(false);
            //have that folder draw itself at this spot
            f.draw(g, x, row, name);

            x = x + HSpace;    //change to next posn
            j++;
            if (j >= HCount) { //reset for next row
                j = 0;
                row += VSpace;
                x = Left;
            }
        }
    }

    public void mouseMoved(MouseEvent e) {
        int j = 0;      //count number in row
        int row = Top;  //start in upper left
        int x = Left;

        //go through all the names and folders
        for (int i = 0; i< names.size(); i++) {
            //see if this folder contains the mouse
            Rectangle r = new Rectangle(x,row,W,H);
            if (r.contains(e.getX(), e.getY())) {
                selectedName=(String)names.elementAt(i);
                repaint();
            }
            x = x + HSpace;      //change to next posn
            j++;
            if (j >= HCount) {   //reset for next row
                j = 0;
                row += VSpace;
                x = Left;
            }
        }
    }
    
    static public void main(String[] argv) {
        new FlyCanvas();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String msgDialog = JOptionPane.showInputDialog("");
		names.add(msgDialog);
		repaint();
	}
}


