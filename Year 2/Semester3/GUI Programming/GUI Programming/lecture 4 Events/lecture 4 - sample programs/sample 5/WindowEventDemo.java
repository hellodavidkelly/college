/*
 * Swing version.
 */

import javax.swing.*;

import java.awt.Dimension;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowEventDemo extends JApplet
                             implements WindowListener,
                                        ActionListener {
    JTextArea display;
    JFrame window;
    JButton b1, b2;
    static final String SHOW = "show";
    static final String CLEAR = "clear";
    final static String newline = "\n";


    public void init() {
        b1 = new JButton("Click to bring up a window.");
        b1.setActionCommand(SHOW);
        b1.addActionListener(this);

        b2 = new JButton("Click to clear the display.");
        b2.setActionCommand(CLEAR);
        b2.addActionListener(this);

        display = new JTextArea();
        display.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setPreferredSize(new Dimension(200, 75));

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(b1, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(b2, BorderLayout.SOUTH);
        setContentPane(contentPane);

        //Create but don't show window.
        window = new JFrame("Window Event Window");
        window.addWindowListener(this);
        JLabel l = new JLabel("The applet listens to this window"
                            + " for window events.");
        window.getContentPane().add(l, BorderLayout.CENTER);
        window.pack();
    }

    public void stop() {
        window.setVisible(false);
    }

    public void windowClosing(WindowEvent e) {
        window.setVisible(false);
        displayMessage("Window closing", e);
    }

    public void windowClosed(WindowEvent e) {
        displayMessage("Window closed", e);
    }

    public void windowOpened(WindowEvent e) {
        displayMessage("Window opened", e);
    }

    public void windowIconified(WindowEvent e) {
        displayMessage("Window iconified", e);
    }

    public void windowDeiconified(WindowEvent e) {
        displayMessage("Window deiconified", e);
    }

    public void windowActivated(WindowEvent e) {
        displayMessage("Window activated", e);
    }

    public void windowDeactivated(WindowEvent e) {
        displayMessage("Window deactivated", e);
    }

    void displayMessage(String prefix, WindowEvent e) {
        display.append(prefix
                       + ": "
                       + e.getWindow()
                       + newline);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == SHOW) {
            window.pack();
            window.setVisible(true);
        } else {
            display.setText("");
        }
    }
}
