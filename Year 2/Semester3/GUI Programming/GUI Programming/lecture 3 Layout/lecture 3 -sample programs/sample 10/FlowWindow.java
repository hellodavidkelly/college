/*
 * Swing version.
 */

import java.awt.*;

import javax.swing.*;

public class FlowWindow extends JFrame {
    boolean inAnApplet = true;

    public FlowWindow() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        contentPane.add(new JButton("Button 1"));
        contentPane.add(new JButton("2"));
        contentPane.add(new JButton("Button 3"));
        contentPane.add(new JButton("Long-Named"));
        contentPane.add(new JButton("Button 5"));


    }

    public static void main(String args[]) {
        FlowWindow window = new FlowWindow();

        window.setTitle("FlowLayout");
        window.pack();
        window.setVisible(true);
    }
}
