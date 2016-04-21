package lab6.part3;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.tree.*;

import composite.Employee;


public class projTree extends JxFrame
implements TreeSelectionListener {
	Project project, sap, website, payroll;
	Project req, analysis, coding;
	Project uml, data, screen;
	
	Project webDesign, webCode, webAnalysis;
	Project webSpecs, webScreens;
	
	Project payCode, payDesign, payTest;

    JScrollPane sp;
    JPanel treePanel;
    JTree tree;
    DefaultMutableTreeNode troot;
    JLabel cost;

    public projTree() {
        super("Project tree");
        makeProjects();
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
        troot = new DefaultMutableTreeNode(project.getName());
        tree= new JTree(troot);
        tree.setBackground(Color.lightGray);
        loadTree(project);
        /* Put the Tree in a scroller. */

        sp.getViewport().add(tree);
        setSize(new Dimension(200, 300));
        setVisible(true);

    }
    //------------------------------------
    public void loadTree(Project topDog) {
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

    private void addNodes(DefaultMutableTreeNode pnode, Project proj) {
        DefaultMutableTreeNode node;

        Enumeration e = proj.subordinates();
        if (e != null) {
            while (e.hasMoreElements()) {
            	Project newProj = (Project)e.nextElement();
                node = new DefaultMutableTreeNode(newProj.getName());
                pnode.add(node);
                addNodes(node, newProj);
            }
        }
    }

    //--------------------------------------

    private void makeProjects() {
        project = new Root("Project", 40000);
        project.add(sap = new Root("SAP",20000));
        project.add(website = new Root("Website", 30000));
        project.add(payroll = new Root("Payroll", 20000));

        sap.add(req = new Root("Requirements", 1000));
        sap.add(analysis = new Root("Analysis", 3000));
        sap.add(coding = new Root("Coding", 4000));

        analysis.add(uml = new Root("UML Diagram", 1000));
        analysis.add(data = new Root("Data Analysis", 5000));
        analysis.add(screen = new Root("Screen Designs", 4000));

        website.add(webDesign = new Root("Design", 1000));
        website.add(webCode = new Root("Code", 1000));
        website.add(webAnalysis = new Root("Analysis", 3000));
        
        webCode.add(webSpecs= new Root("Prog. Specs", 3000));
        webCode.add(webScreens= new Root("Screens", 3000));
        
        payroll.add(payDesign= new Root("Design", 1000));
        payroll.add(payCode= new Root("Coding", 4000));
        payroll.add(payTest= new Root("Testing", 3000));
    }
    //------------------------------------
    private long rand_sal(long salary) {
        return salary +(long)(Math.random () -0.5)*salary/5;
    }
    //--------------------------------------
    public void valueChanged(TreeSelectionEvent evt) {
        TreePath path = evt.getPath();
        String selectedTerm = path.getLastPathComponent().toString();

        Project proj = project.getChild(selectedTerm);
        if (proj != null)
            cost.setText(new Float(proj.getCost()).toString());
    }
    //--------------------------------------
    static public void main(String argv[]) {
        new projTree();
    }
}

