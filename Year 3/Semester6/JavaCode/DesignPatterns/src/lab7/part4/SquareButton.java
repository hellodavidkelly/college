package lab7.part4;

public class SquareButton {

	Command command;
	
	public SquareButton(Command command){
		this.command = command;
	}
	
	public void press(){
		command.execute();
	}
}
