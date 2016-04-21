package lab6.part3;

import java.util.*;

public abstract class AbstractProject {
    protected String name;
    protected float cost;
    protected Project parent = null;
    protected boolean leaf = true;

    public abstract String getName();
    public abstract boolean add(Project e)
        throws NoSuchElementException;
    public abstract void remove(Project e)
        throws NoSuchElementException;
    public abstract Enumeration subordinates();
    public abstract Project getChild(String s);
    public boolean isLeaf() {
        return leaf;
    }
}
