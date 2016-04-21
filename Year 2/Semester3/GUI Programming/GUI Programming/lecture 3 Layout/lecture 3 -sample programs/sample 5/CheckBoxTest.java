// Creating Checkbox buttons.

// Java core packages
import java.awt.*;
import java.awt.event.*;

// Java extension packages
import javax.swing.*;

public class CheckBoxTest extends JFrame {
   private JTextField field;
   private JCheckBox bold, italic;

   // set up GUI
   public CheckBoxTest()
   {
      super( "JCheckBox Test" );

      // get content pane and set its layout
      Container container = getContentPane();
      container.setLayout( new FlowLayout() );

      // set up JTextField and set its font
      field = 
         new JTextField( "Watch the font style change", 20 );
      field.setFont( new Font( "Serif", Font.PLAIN, 14 ) );
      container.add( field );

      // create checkbox objects
      bold = new JCheckBox( "Bold" );
      container.add( bold );     

      italic = new JCheckBox( "Italic" );
      container.add( italic );

      // register listeners for JCheckBoxes
      CheckBoxHandler handler = new CheckBoxHandler();
      bold.addItemListener( handler );
      italic.addItemListener( handler );

      setSize( 275, 100 );
      setVisible( true );
   }

   // execute application
   public static void main( String args[] )
   { 
      CheckBoxTest application = new CheckBoxTest();

      application.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE );
   }

   // private inner class for ItemListener event handling
   private class CheckBoxHandler implements ItemListener {
      private int valBold = Font.PLAIN;
      private int valItalic = Font.PLAIN;

      // respond to checkbox events
      public void itemStateChanged( ItemEvent event )
      {
         // process bold checkbox events
         if ( event.getSource() == bold )

            if ( event.getStateChange() == ItemEvent.SELECTED )
               valBold = Font.BOLD;
            else
               valBold = Font.PLAIN;
               
         // process italic checkbox events
         if ( event.getSource() == italic )

            if ( event.getStateChange() == ItemEvent.SELECTED )
               valItalic = Font.ITALIC;
            else
               valItalic = Font.PLAIN;

         // set text field font
         field.setFont(
            new Font( "Serif", valBold + valItalic, 14 ) );
      }

   }  // end private inner class CheckBoxHandler

}  // end class CheckBoxTest
