package lab7.part4;

import java.awt.Graphics;

public class Triangle implements Shape {
	Graphics g;
	public void draw() {
		/*
		g.drawLine(75, 100, 50, 50);
		g.drawLine(50, 50, 100, 50);
		g.drawLine(100, 50, 75, 100);
		*/
		System.out.println("Triangle");
	}
	
	public void delete(){
		//g.dispose();
		System.out.println("Triangle Deleted");
	}

	
}
