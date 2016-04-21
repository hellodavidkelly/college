package lab7.part4;

public class DrawCircle implements Command{

	Shape circle;
	
	public DrawCircle(Shape circle) {
		this.circle = circle;
	}

	public void execute(){
		circle.draw();
	}
	
	public void undo(){
		circle.delete();
	}
	
	
}
