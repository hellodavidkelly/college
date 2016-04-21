package lab2.part2;

public class NumberFactory {

	public NumberList getNumberList(String list){
		
		if(list.matches(".*\\d.*")){
			int i = list.indexOf('.');
			
			if(i != -1){
				return new DoubleList(list);
			}
			else{
				return new IntList(list);

			}
		
		}else{
			return new CharList(list);   
		}	
	}
}
