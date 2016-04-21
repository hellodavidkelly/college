package lab7.part4;

public class DrawTriangle implements Command{

	Shape triangle;
	
	public DrawTriangle(Shape triangle){
		this.triangle = triangle;
	}
	
	public void execute() {
		triangle.draw();
	}
	
	public void undo(){
		triangle.delete();
	}

}
