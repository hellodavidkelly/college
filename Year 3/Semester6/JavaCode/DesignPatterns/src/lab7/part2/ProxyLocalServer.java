package lab7.part2;
import lab7.part2.RealLocalServer;

public class ProxyLocalServer extends WebServer{
	
	public ProxyLocalServer(){
		this.getConnection();
	}

	public static String getConnection() {
		return "You are attempting to connect to the web but have connected instead to a Proxy. " +
				"All website activity will be monitored \n" + RealLocalServer.getConnection();
	}

}
