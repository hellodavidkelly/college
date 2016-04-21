import java .awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

//This program illustrates the 

public class wealthBuilder extends JxFrame 
  implements ListSelectionListener, ActionListener {
    private JawtList stockList;         //list of funds
    private JButton Plot;               //plot command button
    private JPanel choicePanel;         //right panel
    private multiChoice mchoice;        //ui for right panel
    private Vector Bonds, Stocks, Mutuals;   //3 lists of investments
    private choiceFactory cfact;        //the factory
    
    public wealthBuilder() {
        super("Wealth Builder");     //frame title bar
        setGUI();                    //set up display
        buildStockLists();           //create stock lists
        cfact = new choiceFactory(); //create builder-factory
    }
    //----------------------------------
    private void setGUI() {
        JPanel jp = new JPanel();
        getContentPane().add (jp);
        jp.setLayout(new BorderLayout());
        JPanel p = new JPanel();
        jp.add("Center", p);
        
        //center contains left and right panels
        p.setLayout(new GridLayout(1,2));
        stockList= new JawtList(10);              //left is list of stocks
        stockList.addListSelectionListener(this);
        p.add(stockList);
        stockList.add("Stocks");
        stockList.add("Bonds");
        stockList.add("Mutual Funds");
        stockList.addListSelectionListener(this);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.lightGray);    
        jp.add("South", p1);
        Plot = new JButton("Plot");         
        Plot.setEnabled(false);        //disabled until stock picked
        Plot.addActionListener(this);
        p1.add(Plot);
        //right is empty at first
        choicePanel = new JPanel();
        choicePanel.setBackground(Color.lightGray);
        p.add(choicePanel);

        setBounds(100, 100, 300, 200);
        setVisible(true);
    }
    //----------------------------------
    public void valueChanged(ListSelectionEvent e) {
        //click on list box happens here
        stockList_Click();
    }
    //----------------------------------
    public void actionPerformed(ActionEvent ev) {
        //click on "plot" button sent here
        plDialog pl = new plDialog(this, mchoice);
        pl.show();
    }
    //----------------------------------
    private void stockList_Click() {
        Vector v = null;
        int index = stockList.getSelectedIndex();
        choicePanel.removeAll();  //remove previous ui panel

        //this just switches between 3 different Vectors
        //and passes the one you select to the Builder pattern
        switch (index) {
        case 0:
            v = Stocks;  break;
        case 1:
            v = Bonds;   break;
        case 2:
            v = Mutuals;  
        }
        mchoice = cfact.getChoiceUI(v);    //get one of the UIs
        choicePanel.add(mchoice.getUI());    //insert in right panel
        choicePanel.validate();         //re-layout and display
        choicePanel.repaint ();
        Plot.setEnabled(true);          //allow plots
    }
    //----------------------------------
    private void buildStockLists() {
        //arbitrary list of stock, bond and fund holdings
        Bonds = new Vector();
        Bonds.addElement("CT State GO 2012");
        Bonds.addElement("New York GO 2005");
        Bonds.addElement("GE Corp Bonds");

        Stocks = new Vector();
        Stocks.addElement("Cisco");
        Stocks.addElement("Coca Cola");
        Stocks.addElement("General Electric");
        Stocks.addElement("Harley Davidson");
        Stocks.addElement("IBM");
        Stocks.addElement("Harley Davidson");

        Mutuals = new Vector();
        Mutuals.addElement("Fidelity Magellan");
        Mutuals.addElement("T Rowe Price");
        Mutuals.addElement("Vanguard PrimeCap");
        Mutuals.addElement("Lindner Fund");

    }
    //----------------------------------
    static public void main(String[] argv) {
        new wealthBuilder();
    }
}        

