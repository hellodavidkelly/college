import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.*;


public class Sender extends JPanel implements Chain,
                                   ActionListener
{
   private Chain nextChain;


   private JTextField tx;
   private JButton Send;

   public Sender()
   {
      setLayout(new GridLayout(2,1));
      JPanel tp = new JPanel();
      JPanel bp = new JPanel();
      add(tp);
      add(bp);
      tx = new JTextField(10);
      tp.add(tx);
      Send = new JButton("Send");
      bp.add(Send);
      Send.addActionListener(this);
      setBorder(new TitledBorder("Send commands"));
   }

	public void actionPerformed(ActionEvent e)
	{
	   String mesg = tx.getText();
	   if  ((mesg.length() >0) && (nextChain != null))
		   nextChain.sendToChain(mesg);
	}

	public void addChain(Chain c)
	{
	   nextChain = c;
	}

	public void sendToChain(String mesg){} //this one does nothing

	public Chain getChain()
	{
	   return nextChain;
	}

}
