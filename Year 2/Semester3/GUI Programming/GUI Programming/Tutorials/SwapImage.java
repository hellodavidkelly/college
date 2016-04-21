import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SwapImage extends JFrame implements ActionListener {

  JPanel buttonPanel;
  JButton iSwap;
  Icon openGif, newGif;
  Icon[] myImages = new Icon[4];


  public SwapImage() {

  	openGif= new ImageIcon("images/open.gif");
    newGif = new ImageIcon("images/new.gif");

    int randomNumber = (int)(1 + Math.random()*3);

  	iSwap = new JButton("iSwap");
  	iSwap.setIcon(openGif);

  	buttonPanel = new JPanel();
  	buttonPanel.add(iSwap);

  	iSwap.addActionListener(this);


	getContentPane().add(buttonPanel);
  	setSize(300,300);
  	setVisible(true);


  }


  public static void main(String[] args) {
	  new SwapImage();
  }

  public void actionPerformed(ActionEvent e) {

	iSwap.setIcon(newGif);

	if(iSwap.getIcon()==newGif) {
		System.out.println("This is the new gif");
	}
  }


}