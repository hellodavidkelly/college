import java.util.ArrayList;

interface IntegerBSTInterface{
	
	public void add(int d);
	public boolean contains(int d);
	public ArrayList inOrder();
	public ArrayList preOrder();
	public ArrayList postOrder();
	public void remove(int d);
	public int height();
	
}