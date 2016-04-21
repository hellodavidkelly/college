package lab7.part4;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DrawingGUI extends JFrame implements ActionListener{

	//Circle
	Shape newShapeCircle = CircleRemote.getShape();
	DrawCircle drawCircleShape = new DrawCircle(newShapeCircle);
	CircleButton newCircleButton = new CircleButton(drawCircleShape);
	
	//Square
	Shape newShapeSquare = SquareRemote.getShape();
	DrawCircle drawSquareShape = new DrawCircle(newShapeSquare);
	CircleButton newSquareButton = new CircleButton(drawSquareShape);
	
	//Triangle
	Shape newShapeTriangle = TriangleRemote.getShape();
	DrawCircle drawTriangleShape = new DrawCircle(newShapeTriangle);
	CircleButton newTriangleButton = new CircleButton(drawTriangleShape);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panelNorth = new JPanel();
	JLabel circleLabel = new JLabel();
	JLabel squareLabel = new JLabel();
	JLabel triangleLabel = new JLabel();
	JPanel panelSouth = new JPanel();
	JButton drawCircle = new JButton("Draw Circle");
	JButton drawSquare = new JButton("Draw Square");
	JButton drawTriangle = new JButton("Draw Triangle");
	JButton undo = new JButton("Undo");
	
	public DrawingGUI(){
		panelNorth.setLayout(new BorderLayout());
		panelNorth.add(circleLabel, BorderLayout.NORTH);
		panelNorth.add(squareLabel, BorderLayout.CENTER);
		panelNorth.add(triangleLabel, BorderLayout.SOUTH);
		
		drawCircle.addActionListener(this);
		drawSquare.addActionListener(this);
		drawTriangle.addActionListener(this);
		undo.addActionListener(this);
		
		panelSouth.add(drawCircle);
		panelSouth.add(drawSquare);
		panelSouth.add(drawTriangle);
		panelSouth.add(undo);
		this.add(panelNorth, BorderLayout.NORTH);
		this.add(panelSouth, BorderLayout.SOUTH);
		
		
		
		
		
		this.setVisible(true);
		this.setSize(800, 800);
		this.setLocation(0,0);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		DrawingGUI gui = new DrawingGUI();

	}

	public void actionPerformed(ActionEvent e) {
		newCircleButton.press();
		newSquareButton.press();
		newTriangleButton.press();
	}

}
