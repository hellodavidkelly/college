// Fig. 11.14: LinesRectsOvals.java
// Drawing lines, rectangles and ovals

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class LinesRectsOvals extends JFrame {

   // set window's title bar String and dimensions
   public LinesRectsOvals()
   {
      super( "Drawing lines, rectangles and ovals" );

      setSize( 400, 165 );
      show();
   }

   // display various lines, rectangles and ovals
   public void paint( Graphics g )
   {
      // call superclass's paint method
      super.paint( g );

      g.setColor( Color.red );
      g.drawLine( 5, 30, 350, 30 );

      g.setColor( Color.blue );
      g.drawRect( 5, 40, 90, 55 );
      g.fillRect( 100, 40, 90, 55 );

      g.setColor( Color.cyan );
      g.fillRoundRect( 195, 40, 90, 55, 50, 50 );
      g.drawRoundRect( 290, 40, 90, 55, 20, 20 );

      g.setColor( Color.yellow );   
      g.draw3DRect( 5, 100, 90, 55, true );
      g.fill3DRect( 100, 100, 90, 55, false );

      g.setColor( Color.magenta );
      g.drawOval( 195, 100, 90, 55 );
      g.fillOval( 290, 100, 90, 55 );
   }

   // execute application
   public static void main( String args[] )
   {
      LinesRectsOvals application = new LinesRectsOvals();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class LinesRectsOvals

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
