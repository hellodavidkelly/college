/*
 * Swing version.
 */

import java.awt.*;
import javax.swing.*;

public class BorderWindow extends JFrame {


    public BorderWindow() {
        Container contentPane = getContentPane();
        //Use the content pane's default BorderLayout.
        //contentPane.setLayout(new BorderLayout()); //unnecessary
		JButton button1 = new JButton("Hi");
        contentPane.add(button1,BorderLayout.NORTH);
        contentPane.add(new JButton("2 (CENTER)"),
                        BorderLayout.CENTER);
        contentPane.add(new JButton("Button 3 (WEST)"),
                        BorderLayout.WEST);
        contentPane.add(new JButton("Long-Named Button 4 (SOUTH)"),
                        BorderLayout.SOUTH);
        contentPane.add(new JButton("Button 5 (EAST)"),
                        BorderLayout.EAST);

    }

    public static void main(String args[]) {
        BorderWindow window = new BorderWindow();
        window.setTitle("BorderLayout");
        window.setSize(600,400);
        //window.pack();
        window.setVisible(true);
    }
}
