

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;


public class ComplexityTable extends JPanel {


    public ComplexityTable() {
        super(new GridLayout(1,0));

        //fill in proper column headings below

        String[] columnNames = {"n",
								"log",
                                "linear",
                                "n*log(n)",
                                "quadratic",
                                "cubic",
                                "exponential"};


        Object data [][] = new Object[50][7];

        for (int n=1;n<= 50;n++) {


					data[n-1][0] = new Integer(n);
					data[n-1][1] = new Integer((int)Math.log((double) n));
					data[n-1][2] = new Integer(n);
					data[n-1][3] = new Integer(n*(int)Math.log((double) n));
					data[n-1][4] = new Integer(n*n);
					data[n-1][5] = new Integer(n*n*n);
					data[n-1][6] = new Integer((int)Math.pow(2,n));

					//add in the rest of the table entries!

		}


        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 500));


        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }


    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Complexity Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        ComplexityTable newContentPane = new ComplexityTable();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
