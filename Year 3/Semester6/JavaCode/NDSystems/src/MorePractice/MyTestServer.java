package MorePractice;

import java.io.IOException;

public class MyTestServer {

	public static void main(String[] args) throws IOException {
		MyServer server = new MyServer();
		server.server();
	}

}
