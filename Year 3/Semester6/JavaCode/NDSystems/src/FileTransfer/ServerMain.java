package FileTransfer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
  public static void main(String[] args) throws IOException {
    ServerSocket servsock = new ServerSocket(8080);
    File myFile = new File("/Users/mjrbronchaus/Desktop/College/Semester6/JavaCode/NDSystems/src/FileTransfer/test.odt");
    while (true) {
      Socket sock = servsock.accept();
      byte[] mybytearray = new byte[(int) myFile.length()];
      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
      bis.read(mybytearray, 0, mybytearray.length);
      OutputStream os = sock.getOutputStream();
      os.write(mybytearray, 0, mybytearray.length);
      os.flush();
      sock.close();
    }
  }
}
