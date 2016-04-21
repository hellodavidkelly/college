package lab7.part4;

public class TriangleButton {

	Command command;
	
	public TriangleButton(Command command){
		this.command = command;
	}
	
	public void press(){
		command.execute();
	}
}
