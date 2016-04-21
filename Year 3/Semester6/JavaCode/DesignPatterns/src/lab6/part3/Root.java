package lab6.part3;
import java.util.*;

import composite.Employee;

public class Root extends Project {
    Vector projects;

    public Root(String initName, float initCost) {
        super(initName, initCost);
        leaf = false;
        projects = new Vector();
    }

    public Root(Project proj) {
        //promotes an employee position to a Boss
        //and thus allows it to have employees
        super(proj.getName (), proj.getCost());
        projects = new Vector();
        leaf = false;
    }

    public boolean add(Project e) throws NoSuchElementException {
    	projects.add(e);
        return true;
    }

    public void remove(Project e) throws NoSuchElementException {
    	projects.removeElement(e);
    }

    public Enumeration subordinates () {
        return projects.elements ();
    }

    public Project getChild(String s) throws NoSuchElementException {

    	Project newProj = null;

        if (getName().equals(s))
            return this;
        else {
            boolean found = false;
            Enumeration e = subordinates();
            while (e.hasMoreElements() && (! found)) {
                newProj = (Project)e.nextElement();
                found = newProj.getName().equals(s);
                if (! found) {
                    if (! newProj.isLeaf ()) {
                        newProj = newProj.getChild(s);
                    } else
                        newProj = null;
                    found =(newProj != null);
                }
            }
            if (found)
                return newProj;
            else
                return null;
        }
    }
    //--------------------------------------

    public float getCost() {
        float sum = cost;
        for (int i = 0; i < projects.size(); i++) {
            sum += ((Project)projects.elementAt(i)).getCost();
        }
        return sum;
    }
}
