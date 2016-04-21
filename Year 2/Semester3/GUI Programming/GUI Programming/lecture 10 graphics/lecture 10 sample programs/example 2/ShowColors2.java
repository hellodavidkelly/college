// Fig. 11.6: ShowColors2.java
// Demonstrating JColorChooser.

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class ShowColors2 extends JFrame {
   private JButton changeColorButton;
   private Color color = Color.lightGray;
   private Container container;

   // set up GUI
   public ShowColors2()
   {
      super( "Using JColorChooser" );

      container = getContentPane();
      container.setLayout( new FlowLayout() );

      // set up changeColorButton and register its event handler
      changeColorButton = new JButton( "Change Color" );

      changeColorButton.addActionListener(

         // anonymous inner class
         new ActionListener() {

            // display JColorChooser when user clicks button
            public void actionPerformed( ActionEvent event )
            {
               color = JColorChooser.showDialog(
                  ShowColors2.this, "Choose a color", color );

               // set default color, if no color is returned
               if ( color == null );
                  //color = Color.lightGray;

               // change content pane's background color
               container.setBackground( color );
			}

         }  // end anonymous inner class

      ); // end call to addActionListener

      container.add( changeColorButton );

      setSize( 400, 130 );
      show();
   }

   // execute application
   public static void main( String args[] )
   {
      ShowColors2 application = new ShowColors2();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

}  // end class ShowColors2

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
