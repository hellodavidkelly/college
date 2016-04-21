public class BNode{ 
	private int data;
	private BNode left; 
	private BNode right;
	
	public BNode(int d){
		data = d; 
		left = null; 
		right = null; 
	}
	public int data(){
		return data;
	}
	public void set(int d){
		data = d;
	}
	public BNode left(){
		 return left;
	}
	public BNode right(){
		 return right;
	} 
	public void setLeft(BNode k){
		 left = k;
	} 
	public void setRight(BNode k){
		 right =k;
	}
}