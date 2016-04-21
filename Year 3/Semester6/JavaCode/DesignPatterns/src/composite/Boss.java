package composite;

import java.util.*;

public class Boss extends Employee {
    Vector employees;

    public Boss(String initName, long initSalary) {
        super(initName, initSalary);
        leaf = false;
        employees = new Vector();
    }

    public Boss(Employee initParent, String initName, long initSalary) {
        super(initParent, initName, initSalary);
        leaf = false;
        employees = new Vector();
    }

    public Boss(Employee emp) {
        //promotes an employee position to a Boss
        //and thus allows it to have employees
        super(emp.getName (), emp.getSalary());
        employees = new Vector();
        leaf = false;
    }

    public boolean add(Employee e) throws NoSuchElementException {
        employees.add(e);
        return true;
    }

    public void remove(Employee e) throws NoSuchElementException {
        employees.removeElement(e);
    }

    public Enumeration subordinates () {
        return employees.elements ();
    }

    public Employee getChild(String s) throws NoSuchElementException {

        Employee newEmp = null;

        if (getName().equals(s))
            return this;
        else {
            boolean found = false;
            Enumeration e = subordinates();
            while (e.hasMoreElements() && (! found)) {
                newEmp = (Employee)e.nextElement();
                found = newEmp.getName().equals(s);
                if (! found) {
                    if (! newEmp.isLeaf ()) {
                        newEmp = newEmp.getChild(s);
                    } else
                        newEmp = null;
                    found =(newEmp != null);
                }
            }
            if (found)
                return newEmp;
            else
                return null;
        }
    }
    //--------------------------------------


    public float getSalaries() {
        float sum = salary;
        for (int i = 0; i < employees.size(); i++) {
            sum += ((Employee)employees.elementAt(i)).getSalaries();
        }
        return sum;
    }


}
