package lab7.part2;

public class WebClient {

	public static void main(String[] args) {
		ProxyLocalServer proxy = new ProxyLocalServer();
		System.out.println(proxy.getConnection());
	}

}
