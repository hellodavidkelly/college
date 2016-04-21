package lab5.part3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import lab5.part2.BlueDecorator;
import lab5.part2.NoDecorator;
import lab5.part2.RedDecorator;

public class ManGUI extends JFrame implements ActionListener {

	DirectorFactory dFact = new DirectorFactory();

	JPanel panel = new JPanel(new BorderLayout());
	JPanel manPanel = new JPanel();
	String[] options = {"LegoMan", "StickMan"};
	JComboBox selection = new JComboBox(options);
	
	public ManGUI(){
		super("Man GUI BUILDER");
		selection.addActionListener(this);
		panel.add(selection, BorderLayout.NORTH);
		panel.add(manPanel, BorderLayout.SOUTH);
		this.add(panel);
		this.setVisible(true);
		this.setSize(400,400);
		this.setLocation(500,0);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		manPanel.removeAll();
		manPanel.add(dFact.choice(selection.getSelectedIndex()));
		manPanel.revalidate();
	}
}
