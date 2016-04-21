package MorePractice;

import java.io.*;
import java.net.*;

class Server
{
   public static void main (String [] args) throws IOException
   {
      System.out.println ("Server starting ...\n");

      // Create a datagram socket bound to port 10000. Datagram
      // packets sent from client programs arrive at this port.

      DatagramSocket s = new DatagramSocket (10000);

      // Create a byte array to hold data contents of datagram
      // packet.

      byte [] data = new byte [100];

      // Create a DatagramPacket object that encapsulates a reference
      // to the byte array and destination address information. The
      // DatagramPacket object is not initialized to an address 
      // because it obtains that address from the client program.

      DatagramPacket dgp = new DatagramPacket (data, data.length);

      // Enter an infinite loop. Press Ctrl+C to terminate program.

      while (true)
      {
         // Receive a datagram packet from the client program.

         s.receive (dgp);

         // Display contents of datagram packet.

         System.out.println (new String (data));

         // Echo datagram packet back to client program.

         s.send (dgp);
      }
   }
}