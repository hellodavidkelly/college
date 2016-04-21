import java.util.*;

class IntegerBSTTest{
	public static void main(String args[]){
		
		IntegerBST intBst = new IntegerBST();
		
		int items[] = {9, 6, 14, 8, 11, 17, 15};
		
		for(int i = 0; i < items.length; i++){
			intBst.add(items[i]);
		}
		
		System.out.println("Tree contains the value 14 is " + intBst.contains(14));
		
		ArrayList inorder = intBst.inOrder();
		System.out.println("In-order " + inorder.toString());
		
		ArrayList preorder = intBst.preOrder();
		System.out.println("Pre-order " + preorder.toString());
		
		ArrayList postorder = intBst.postOrder();
		System.out.println("Post-order " + postorder.toString());
		
		System.out.println("Height of tree =  " + intBst.height());
		
		intBst.remove(14);
		
		inorder = intBst.inOrder();
		System.out.println("In-order " + inorder.toString());
		
	}
}