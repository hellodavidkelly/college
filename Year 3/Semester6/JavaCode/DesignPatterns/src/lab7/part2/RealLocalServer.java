package lab7.part2;

public class RealLocalServer extends WebServer{

	public RealLocalServer(){
		this.getConnection();
	}
	
	public static String getConnection() {
		return "You have connected to the real local server directly";
	}

}
