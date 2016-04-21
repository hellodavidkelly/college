package lab5.part2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lab5.part2.RedDecorator;

public class BorderGUI extends JxFrame implements ActionListener {

	JButton Quit;
	JLabel label = new JLabel();
	String[] options = {"Red Border", "Blue Border", "No Border"};
    JPanel jpN = new JPanel();
    JPanel jpS = new JPanel(new BorderLayout());

	JComboBox combo = new JComboBox(options);
	
	public BorderGUI()	{
      super ("Deco Button");
      getContentPane().add(jpN, BorderLayout.NORTH);
      getContentPane().add(jpS, BorderLayout.CENTER);
      jpN.add(combo);
      combo.addActionListener(this);
      setSize(new Dimension(300,300));
      setVisible(true);
   }
   
	public void actionPerformed(ActionEvent e)
	{
		setBorder();
	}
	
	public void setBorder(){
		if(combo.getSelectedIndex()==0){
			System.out.println("0");
			jpS.removeAll();
			jpS.add(new RedDecorator(label));
			jpS.revalidate();
		}
		if(combo.getSelectedIndex()==1){
			System.out.println("1");
			jpS.removeAll();
			jpS.add(new BlueDecorator(label));
			jpS.revalidate();
		}
		if(combo.getSelectedIndex()==2){
			System.out.println("2");
			jpS.removeAll();
			jpS.add(new NoDecorator(label));
			jpS.revalidate();
		}
	}
	
	static public void main(String argv[])
	{
		new BorderGUI();
	}
}
