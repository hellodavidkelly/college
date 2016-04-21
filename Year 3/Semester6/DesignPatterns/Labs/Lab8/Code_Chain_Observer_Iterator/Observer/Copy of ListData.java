import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class ListData extends AbstractListModel
{
    private Vector data;

    public ListData()
    {
        data = new Vector();
    }
    public int getSize()
    {
        return data.size();
    }
    public Object getElementAt(int index)
    {
        return data.elementAt(index);
    }
    public void addElement(String s)
    {
        data.addElement(s);
        fireIntervalAdded(this, data.size()-1, data.size());
    }
}