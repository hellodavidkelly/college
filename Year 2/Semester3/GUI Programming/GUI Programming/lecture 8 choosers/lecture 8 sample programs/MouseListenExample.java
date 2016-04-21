/*
 * Mouse Listener Example
 * Luke Raeside
 */

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;

import java.awt.*;
import java.awt.event.*;

public class MouseListenExample extends JFrame implements MouseInputListener {

	JPanel mousePanel, actionsPanel;
	JLabel mouseLabel;
	JLabel topLeft,topLeftMid,topRightMid,topRight,midLeft,midLeftMid,midRightMid,midRight,btmLeft,btmLeftMid,btmRightMid,btmRight;

	
	public MouseListenExample() {
		

		buildGUI();
		buildActionsPanel();
		mousePanel.add(actionsPanel);
		getContentPane().add(mousePanel);
		
		setSize(800,400);
		setVisible(true);
		
	}
	
	public void buildGUI() {
		
		mousePanel = new JPanel();
		actionsPanel = new JPanel();
		actionsPanel.setLayout(new GridLayout(3,4));
		
		mousePanel.setLayout(new BorderLayout());
		mouseLabel = new JLabel();
		mouseLabel.setForeground(Color.RED);
		mouseLabel.setBorder(new LineBorder(Color.BLACK));
		mouseLabel.setText("Current Mouse Action Listed Here");
		mousePanel.add(mouseLabel,BorderLayout.SOUTH);
		mousePanel.addMouseListener(this);
		mousePanel.addMouseMotionListener(this);
			
	}
	
	public void buildActionsPanel() {
		
		topLeft = new JLabel();
		topLeftMid = new JLabel();
		topLeftMid.setBorder(new LineBorder(Color.BLACK));
		topLeftMid.addMouseListener(this);
		topRightMid = new JLabel();
		topRightMid.setBorder(new LineBorder(Color.BLACK));
		topRightMid.addMouseListener(this);
		topRight = new JLabel();
		
		midLeft = new JLabel();
		midLeftMid = new JLabel();
		midLeftMid.setBorder(new LineBorder(Color.BLACK));
		midLeftMid.addMouseListener(this);
		midRightMid = new JLabel();
		midRightMid.setBorder(new LineBorder(Color.BLACK));
		midRightMid.addMouseListener(this);
		midRight = new JLabel();
		
		btmLeft = new JLabel();
		btmLeftMid = new JLabel();
		btmRightMid = new JLabel();
		btmRight = new JLabel();
		
		actionsPanel.add(topLeft);
		actionsPanel.add(topLeftMid);
		actionsPanel.add(topRightMid);
		actionsPanel.add(topRight);
		actionsPanel.add(midLeft);
		actionsPanel.add(midLeftMid);
		actionsPanel.add(midRightMid);
		actionsPanel.add(midRight);
		actionsPanel.add(btmLeft);
		actionsPanel.add(btmLeftMid);
		actionsPanel.add(btmRightMid);
		actionsPanel.add(btmRight);
	}
	
	
	public static void main(String[] args) {
		new MouseListenExample();
	}

	public void mouseClicked(MouseEvent e) {
		mouseLabel.setText("Mouse Click Event");
		if(e.getSource() instanceof JLabel) {
			((JLabel)e.getSource()).setText("Click\n" + e.getX() + " " + e.getY() + "\n" + " \nTop " + e.getXOnScreen() + " " + e.getYOnScreen());
		}
	}

	public void mouseEntered(MouseEvent e) {
		mouseLabel.setText("Mouse Entered Event");
		if(e.getSource() instanceof JLabel) {
			((JLabel)e.getSource()).setText("Enter");
		}		
	}

	public void mouseExited(MouseEvent e) {
		mouseLabel.setText("Mouse Exit Event");
		if(e.getSource() instanceof JLabel) {
			((JLabel)e.getSource()).setText("Exit");
		}		
	}

	public void mousePressed(MouseEvent e) {
		mouseLabel.setText("Mouse Pressed Event");
		if(e.getSource() instanceof JLabel) {
			((JLabel)e.getSource()).setText("Pressed");
		}		
	}

	public void mouseReleased(MouseEvent e) {
		mouseLabel.setText("Mouse Released Event");	
		if(e.getSource() instanceof JLabel) {
			((JLabel)e.getSource()).setText("Release");
		}		
	}

	public void mouseDragged(MouseEvent e) {
		mouseLabel.setText("Mouse Dragged " + e.getX() + " " + e.getY() + "\n" + " \nTop " + e.getXOnScreen() + " " + e.getYOnScreen());	
		if(e.getSource() instanceof JLabel) {
			((JLabel)e.getSource()).setText("Drag");
		}		
	}

	public void mouseMoved(MouseEvent e) {
		mouseLabel.setText("Mouse Move " + e.getX() + " " + e.getY() + "\n" + " \nTop " + e.getXOnScreen() + " " + e.getYOnScreen());	
		if(e.getSource() instanceof JLabel) {
			((JLabel)e.getSource()).setText("Move");
		}		
	}
	
}
