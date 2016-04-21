package lab7.part4;

public class DrawSquare implements Command{

	Shape square;
	
	public DrawSquare(Shape square){
		this.square = square;
	}
	
	public void execute() {
		square.draw();
	}
	
	public void undo(){
		square.delete();
	}

}
