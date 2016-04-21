package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import factoryClasses.*;
import gamePieces.*;

@SuppressWarnings("serial")
public class BattleGameInterface extends JFrame implements ActionListener {

	final int MAX = 5;
	Vector<JButton> buttonList = new Vector<JButton>((MAX*MAX));
	Vehicle[] vehicleLocation = new Vehicle[MAX*MAX];
	DamageItem[] damageLocation = new DamageItem[MAX*MAX];
	
	JPanel buttonPanel = new JPanel();
	JPanel selectionPanel = new JPanel();
	String[] selection = {"Land Battle","Sea Battle"};
	JComboBox selectBattle = new JComboBox(selection);
	
	BattleGameAbstractFactory gameFactory = new LandGameConcreteFactory();
	private final int MAX_BATTLE_ITEMS=3;
	private final int MAX_DAMAGE_ITEMS=3;	
		
	public BattleGameInterface() {
		createButtons();
		addButtons();
		addListeners();
		setRandomBattleItems();
		setRandomDamageItems();
		buildSelectionPanel();		
		
		this.getContentPane().add(buttonPanel);
		this.getContentPane().add(selectionPanel,BorderLayout.SOUTH);
		
		setSize(400,400);
		setVisible(true);
		
	}
	
	private void reset() {
		for(int i = 0; i < MAX*MAX ; i++) {
			buttonList.elementAt(i).setIcon(null);
			vehicleLocation[i]=null;
			damageLocation[i]=null;

		}
		setRandomBattleItems();
		setRandomDamageItems();
		validate();
	}
	
	private void buildSelectionPanel() {
		selectionPanel.add(selectBattle);
		selectBattle.addActionListener(this);
		
	}

	private void createButtons() {
		System.out.println("Create Buttons" + buttonList.size());
		
		for(int i=0;i<(MAX*MAX);i++) {
			JButton currentButton = new JButton();
			buttonList.add(currentButton);
		}
		System.out.println("Create Buttons>End" + buttonList.size());
	}
	
	private void addListeners() {
		for(int i=0;i<buttonList.size();i++) {
			buttonList.elementAt(i).addActionListener(this);
		}		
	}


	private void addButtons() {
		System.out.println("Add Buttons" + buttonList.size());
		buttonPanel.setLayout(new GridLayout(MAX,MAX));
		for(int i=0;i<buttonList.size();i++) {
			buttonPanel.add(buttonList.elementAt(i));
		}		
		
	}
	
	private void setRandomBattleItems() {
		int numBattleItems = 0;
		
		while(numBattleItems<MAX_BATTLE_ITEMS) {
			for(int i=0;i<MAX_BATTLE_ITEMS;i++) {
				int randomNum = (int)(Math.random()*(MAX*MAX));
				if(isFreeCell(randomNum) && numBattleItems<MAX_BATTLE_ITEMS) {
					vehicleLocation[randomNum]=gameFactory.getBattleVehicle();
					System.out.println("Set Vehicle item at " + randomNum + " total " + numBattleItems);

					numBattleItems++;
				}
			}
		}
		
	}
	
	private void setRandomDamageItems() {
		int numDamageItems=0;
		
		while(numDamageItems<MAX_DAMAGE_ITEMS) {
			for(int i=0;i<MAX_DAMAGE_ITEMS;i++) {
				  int randomNum = (int)(Math.random()*(MAX*MAX));
				  if(isFreeCell(randomNum) && numDamageItems < MAX_DAMAGE_ITEMS) {
					  damageLocation[randomNum]=gameFactory.getDamageItem();
					  System.out.println("Set Damage item at " + randomNum + " total " + numDamageItems);
					  if(numDamageItems<MAX_DAMAGE_ITEMS) {
						  numDamageItems++;
					  }
				  }
			}	
		}
	}
	
	private boolean isFreeCell(int Location) {
		System.out.println(damageLocation[Location] + " " + vehicleLocation[Location] + "\n");
		
		if(damageLocation[Location]==null && vehicleLocation[Location]==null) {
			System.out.println("Cell Free at loc " + Location);
			return true;
		}
		else {
			System.out.println("Cell Not Free attempt at loc " + Location);
			return false;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			//Location of Button same as Location of Damage or Vehicle
			//Change the image to the correct image
			for(int i=0; i<buttonList.size();i++) {
				if(e.getSource()==buttonList.elementAt(i)) { //match button and location
					if(damageLocation[i] instanceof DamageItem) {//if location has damage item
						//set the icon to the image of the damage item found
						buttonList.elementAt(i).setIcon(damageLocation[i].getImage());
					}
					
					if(vehicleLocation[i] instanceof Vehicle) {//if location has damage item
						//set the icon to the image of the damage item found
						buttonList.elementAt(i).setIcon(vehicleLocation[i].getImage());
					}
					
				}
			}
		}
		else {
			if(e.getSource()==selectBattle) {
				if(selectBattle.getSelectedIndex()==0) {
					gameFactory = new LandGameConcreteFactory();
				}
				else {
					gameFactory = new SeaGameConcreteFactory();
				}
			}
			reset();
			validate();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new BattleGameInterface();
	}

}
