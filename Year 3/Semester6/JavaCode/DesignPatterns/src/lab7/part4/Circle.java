package lab7.part4;

import java.awt.Graphics;

import javax.swing.JLabel;

public class Circle implements Shape{
	Graphics g;
	public void draw() {
		//g.drawOval(25,35,25,25);
		System.out.println("Circle");
	}
	
	public void delete(){
		g.dispose();
	}
	
}
