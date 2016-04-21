package lab2.part1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ComboViewController {

	private HobbyList hobbyList;
	private ComboView comboView;
	private ListView listView;
	String newHobby;
	
	public ComboViewController(HobbyList hobbyList,ComboView comboView ,ListView listView){
		
		this.hobbyList = hobbyList;
		this.comboView =  comboView;
		this.listView = listView;
		
		this.comboView.addHobbyListener(new AddListener());
		this.comboView.refreshHobbyListener(new RefreshListener());
		
		this.listView.refreshHobbyListener(new RefreshListListener());
	}

	class AddListener implements ActionListener{
	
		public void actionPerformed(ActionEvent e) {

			
			try{
				//newHobby = comboView.getNewHobby();
				hobbyList.addHobby(newHobby);
				System.out.println(hobbyList.getHobby());
				//comboView.setHobbies();
				comboView.validate();
			}catch(Exception err){
				System.out.print("Error");
			}
		}
	}
	
	class RefreshListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			try{
				System.out.println("New Refreshed List Contatins: " + hobbyList.getHobby());
				comboView.setTextField();
				comboView.setCombo();
			}catch(Exception err){
				System.out.print("Error");
			}
		}		
	}
	
	class RefreshListListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			try{
				//listView.addHobbiesToList();
				System.out.println("New Refreshed List Contatins: " + hobbyList.getHobby());
				listView.validate();
				listView.refreshList();
			}catch(Exception err){
				System.out.print("Error");
			}
		}
	}	
	
}


