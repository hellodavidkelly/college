import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MainWindow extends JFrame
             implements ActionListener
{
    private JButton add;
	private JTextField text;
    private JList list;
	private ListData listdata;

	public MainWindow()
	{
		super("Main Window");

		add = new JButton("Add");
		add.addActionListener(this);

		text = new JTextField();
		listdata = new ListData();
		list = new JList(listdata);

		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(BorderLayout.NORTH, text);
		c.add(BorderLayout.SOUTH, add);
		c.add(BorderLayout.CENTER, list);

		setSize(200,200);
		show();
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == add)
		{
			System.out.println("Adding");
			listdata.addElement(text.getText());
		}
	}

	public static void main(String[] args)
	{
		MainWindow mainframe = new MainWindow();
	}
}