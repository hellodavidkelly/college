package lab2.part2;


public class CharList extends NumberList{
	
	int size;
	
	CharList(String list){ 
		size = 0;
		size = list.length();
		// Allocate some space for the array
		charList = new char[size];
		
		// Store each list item an the appropriate array 
		for(int i = 0; i < size; i++){
			charList[i] = list.charAt(i);
		}
	}
	
	public Number sum(){
		return null;
	}
	
	public void display(){
		
		System.out.println("Character List"); 
		
		for(int i = 0; i < size; i++){
			System.out.println("[" + i + "] = " + charList[i]);
		}
	}

}
