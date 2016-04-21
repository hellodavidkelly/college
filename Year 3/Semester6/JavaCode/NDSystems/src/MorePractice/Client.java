package MorePractice;

import java.io.*;
import java.net.*;

class Client
{
   public static void main (String [] args)
   {
      String host = "localhost";

      // If user specifies a command-line argument, that argument
      // represents the host name.

      DatagramSocket s = null;

      try
      {
          // Create a datagram socket bound to an arbitrary port.

          s = new DatagramSocket ();

          // Create a byte array that will hold the data portion of a
          // datagram packet's message. That message originates as a
          // String object, which gets converted to a sequence of
          // bytes when String's getBytes() method is called. The
          // conversion uses the platform's default character set.

          byte [] buffer;
          buffer = new String ("Send me a datagram").getBytes ();

          // Convert the name of the host to an InetAddress object.
          // That object contains the IP address of the host and is
          // used by DatagramPacket.

          InetAddress ia = InetAddress.getByName (host);

          // Create a DatagramPacket object that encapsulates a
          // reference to the byte array and destination address
          // information. The destination address consists of the
          // host's IP address (as stored in the InetAddress object)
          // and port number 10000 -- the port on which the server
          // program listens.

          DatagramPacket dgp = new DatagramPacket (buffer,
                                                   buffer.length,
                                                   ia,
                                                   10000);

          // Send the datagram packet over the socket.

          s.send (dgp);

          // Create a byte array to hold the response from the server.
          // program.

          byte [] buffer2 = new byte [100];

          // Create a DatagramPacket object that specifies a buffer
          // to hold the server program's response, the IP address of
          // the server program's computer, and port number 10000.

          dgp = new DatagramPacket (buffer2,
                                    buffer.length,
                                    ia,
                                    10000);

          // Receive a datagram packet over the socket.

          s.receive (dgp);

          // Print the data returned from the server program and stored
          // in the datagram packet.

          System.out.println (new String (dgp.getData ()));

      }
      catch (IOException e)
      {
          System.out.println (e.toString ());
      }
      finally
      {
          if (s != null)
              s.close ();
      }
   }
}