package lab2.part1.part2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewController {

	HobbyList hobbyList;
	ListView listView;
	ComboView comboView;
	
	
	public ViewController(HobbyList hobbyList, ListView listView, ComboView comboView){
		
		this.hobbyList = hobbyList;
		this.listView = listView;
		this.comboView = comboView;
		
		this.comboView.addNewHobbyButtonListener(new addHobbyComboListener());
		this.comboView.refreshButtonListener(new refreshHobbyComboListener());
		
		this.listView.addNewHobbyButtonListener(new addHobbyListListener());
		this.listView.refreshButtonListener(new refreshHobbyListListener());

	}

	//JComboBox Listeners!!
	class addHobbyComboListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			try{
				String newHobby = comboView.getTextField();
				Hobby hobby = new Hobby(newHobby);
				hobbyList.addHobby(hobby);
				//System.out.println(newHobby+": Addes to hobbyList");
				comboView.addNewHobbyCombo(hobbyList.getHobby());
			}catch(Exception err){
				//System.out.print("Error");
			}		
		}	
	}
	
	class refreshHobbyComboListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			try{
				comboView.refreshCombo(hobbyList.getHobby());
			}catch(Exception err){
				//System.out.print("Error");
			}		
		}	
	}
	//End JComboBox Listeners!!
	
	//JList Listeners!!
	class addHobbyListListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			try{
				String newListHobby;
				newListHobby = listView.getTextField();
				Hobby hobby = new Hobby(newListHobby);
				hobbyList.addHobby(hobby);
				//ListView.addNewHobby(hobby);
			}catch(Exception err){
				//System.out.print("Error");
			}	
		}	
	}	
	
	class refreshHobbyListListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			try{
				listView.refreshList(hobbyList.getHobby());
			}catch(Exception err){
				//System.out.print("Error");
			}		
		}	
	}	
	
}
