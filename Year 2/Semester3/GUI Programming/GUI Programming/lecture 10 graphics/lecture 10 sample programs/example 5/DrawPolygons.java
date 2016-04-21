// Fig. 11.21: DrawPolygons.java
// Drawing polygons

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class DrawPolygons extends JFrame {

   // set window's title bar String and dimensions
   public DrawPolygons()
   {
      super( "Drawing Polygons" );

      setSize( 275, 230 );
      show();
   }

   // draw polygons and polylines
   public void paint( Graphics g )
   {
      // call superclass's paint method
      super.paint( g );

      int xValues[] = { 20, 40, 50, 30, 20, 15 };
      int yValues[] = { 50, 50, 60, 80, 80, 60 };
      Polygon polygon1 = new Polygon( xValues, yValues, 6 );

      g.drawPolygon( polygon1 );

      int xValues2[] = { 70, 90, 100, 80, 70, 65, 60 };
      int yValues2[] = { 100, 100, 110, 110, 130, 110, 90 };

      g.drawPolyline( xValues2, yValues2, 7 );

      int xValues3[] = { 120, 140, 150, 190 };
      int yValues3[] = { 40, 70, 80, 60 };

      g.fillPolygon( xValues3, yValues3, 4 );

      Polygon polygon2 = new Polygon();
      polygon2.addPoint( 165, 135 );
      polygon2.addPoint( 175, 150 );
      polygon2.addPoint( 270, 200 );
      polygon2.addPoint( 200, 220 );
      polygon2.addPoint( 130, 180 );

      g.fillPolygon( polygon2 );
   }

   // execute application
   public static void main( String args[] )
   {
      DrawPolygons application = new DrawPolygons();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class DrawPloygons

/**************************************************************************
 * (C) Copyright 2002 by Deitel & Associates, Inc. and Prentice Hall.     *
 * All Rights Reserved.                                                   *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
