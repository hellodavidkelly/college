package composite;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.tree.*;


public class empTree extends JxFrame
implements TreeSelectionListener {
    Employee prez, marketVP, prodVP;
    Employee salesMgr, advMgr;
    Employee prodMgr, shipMgr;

    JScrollPane sp;
    JPanel treePanel;
    JTree tree;
    DefaultMutableTreeNode troot;
    JLabel cost;

    public empTree() {
        super("Employee tree");
        makeEmployees();
        setGUI();
    }
    //--------------------------------------
    private void setGUI() {
        treePanel = new JPanel();
        getContentPane().add(treePanel);
        treePanel.setLayout(new BorderLayout());

        sp = new JScrollPane();
        treePanel.add("Center", sp);
        treePanel.add("South", cost = new JLabel("          "));

        treePanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        troot = new DefaultMutableTreeNode(prez.getName());
        tree= new JTree(troot);
        tree.setBackground(Color.lightGray);
        loadTree(prez);
        /* Put the Tree in a scroller. */

        sp.getViewport().add(tree);
        setSize(new Dimension(200, 300));
        setVisible(true);

    }
    //------------------------------------
    public void loadTree(Employee topDog) {
        DefaultMutableTreeNode troot;
        troot = new DefaultMutableTreeNode(topDog.getName());
        treePanel.remove(tree);
        tree= new JTree(troot);
        tree.addTreeSelectionListener(this);
        sp.getViewport().add(tree);

        addNodes(troot, topDog);
        tree.expandRow(0);
        repaint();
    }
    //--------------------------------------

    private void addNodes(DefaultMutableTreeNode pnode, Employee emp) {
        DefaultMutableTreeNode node;

        Enumeration e = emp.subordinates();
        if (e != null) {
            while (e.hasMoreElements()) {
                Employee newEmp = (Employee)e.nextElement();
                node = new DefaultMutableTreeNode(newEmp.getName());
                pnode.add(node);
                addNodes(node, newEmp);
            }
        }
    }

    //--------------------------------------

    private void makeEmployees() {
        prez = new Boss("CEO", 200000);
        prez.add(marketVP = new Boss("Marketing VP", 100000));
        prez.add(prodVP = new Boss("Production VP", 100000));

        marketVP.add(salesMgr = new Boss("Sales Mgr", 50000));
        marketVP.add(advMgr = new Boss("Advt Mgr", 50000));
        //add salesmen reporting to sales manager
        for (int i=0; i<5; i++)
            salesMgr .add(new Employee("Sales "+ i, rand_sal(30000)));
        advMgr.add(new Employee("Secy", 20000));

        prodVP.add(prodMgr = new Boss("Prod Mgr", 40000));
        prodVP.add(shipMgr = new Boss("Ship Mgr", 35000));
        //add manufacturing staff
        for (int i = 0; i < 4; i++)
            prodMgr.add( new Employee("Manuf "+i, rand_sal(25000)));
        //add shipping clerks
        for (int i = 0; i < 3; i++)
            shipMgr.add( new Employee("ShipClrk "+i, rand_sal(20000)));
    }


    //--------------------------------------
    private long rand_sal(long salary) {
        return salary +(long)(Math.random () -0.5)*salary/5;
    }
    //--------------------------------------
    public void valueChanged(TreeSelectionEvent evt) {
        TreePath path = evt.getPath();
        String selectedTerm = path.getLastPathComponent().toString();

        Employee emp = prez.getChild(selectedTerm);
        if (emp != null)
            cost.setText(new Float(emp.getSalaries()).toString());
    }
    //--------------------------------------
    static public void main(String argv[]) {
        new empTree();
    }
}

