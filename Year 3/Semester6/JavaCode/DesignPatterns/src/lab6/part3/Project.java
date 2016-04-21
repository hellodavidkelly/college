package lab6.part3;

import java.util.*;

public class Project extends AbstractProject {
    public Project(String initName, float initCost) {
        name = initName;
        cost = initCost;
        leaf = true;
    }
    //--------------------------------------
    public Project(Project initParent, String initName, float initCost) {
        name = initName;
        cost = initCost;
        parent = initParent;
        leaf = true;
    }
    //--------------------------------------
    public String getName() {
        return name;
    }
    //--------------------------------------

    public boolean add(Project e) throws NoSuchElementException {
        throw new NoSuchElementException("No subordinates");
    }

    public void remove(Project e) throws NoSuchElementException {
        throw new NoSuchElementException("No subordinates");
    }

    public Enumeration subordinates () {
        Vector v = new Vector();
        return v.elements ();
    }
    
    //--------------------------------------
    public Project getChild(String s) throws NoSuchElementException {
        throw new NoSuchElementException("No children");
    }
    //--------------------------------------
    
    public float getCost(){
    	return cost;
    }
    
    public Project getParent() {
        return parent;
    }

}
