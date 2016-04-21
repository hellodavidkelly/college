package lab7.part4;

public class CircleButton {

	Command command;
	
	public CircleButton(Command command){
		this.command = command;
	}
	
	public void press(){
		command.execute();
	}
}
