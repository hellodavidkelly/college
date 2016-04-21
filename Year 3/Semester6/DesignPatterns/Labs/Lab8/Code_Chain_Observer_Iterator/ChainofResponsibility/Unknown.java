import javax.swing.*;
import java.util.*;
import javax.swing.border.*;
import java.awt.*;


public class Unknown extends JPanel implements Chain
{
	private Chain nextChain = null;

	private JList list;
    private JListData data;

	public Unknown()
	{
		setBorder(new TitledBorder("Unknown Commands"));

		data = new JListData();
		list = new JList(data);

		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, list);
	}
	public void addChain(Chain c)
	{
		nextChain = c;
	}

	public void sendToChain(String mesg)
	{
		// Last in chain
		addUnknown(mesg);

		if (nextChain != null)
			nextChain.sendToChain(mesg);

	}

	public Chain getChain()
	{
		return nextChain;
    }

	public void addUnknown(String mesg)
	{
		data.addElement(mesg);
	}
}

class JListData extends AbstractListModel
{
   private Vector data;

   public JListData()
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

   public void removeElement(String s)
   {
      data.removeElement(s);
      fireIntervalRemoved(this, 0, data.size());
   }
}