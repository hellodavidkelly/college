import java.util.*;

public class Employee extends AbstractEmployee {
    public Employee(String initName, float initSalary) {
        name = initName;
        salary = initSalary;
        leaf = true;
    }
    //--------------------------------------
    public Employee(Employee initParent, String initName, float initSalary) {
        name = initName;
        salary = initSalary;
        parent = initParent;
        leaf = true;
    }
    //--------------------------------------
    public float getSalary() {
        return salary;
    }
    //--------------------------------------
    public String getName() {
        return name;
    }
    //--------------------------------------


    public boolean add(Employee e) throws NoSuchElementException {
        throw new NoSuchElementException("No subordinates");
    }

    public void remove(Employee e) throws NoSuchElementException {
        throw new NoSuchElementException("No subordinates");
    }




    public Enumeration subordinates () {
        Vector v = new Vector();
        return v.elements ();
    }



    //--------------------------------------
    public Employee getChild(String s) throws NoSuchElementException {
        throw new NoSuchElementException("No children");
    }

    //--------------------------------------
    public float getSalaries() {
        return salary;
    }
    //--------------------------------------
    public Employee getParent() {
        return parent;
    }
}
