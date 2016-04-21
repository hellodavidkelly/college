package lab7.part4;

import java.awt.Graphics;

public class Square implements Shape{
	Graphics g;
	public void draw() {
		//g.drawRect(35,45,25,25);
		System.out.println("Square");
	}
	
	public void delete(){
		g.dispose();
	}
	
}
