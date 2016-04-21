import java.util.ArrayList;

public class IntegerBST implements IntegerBSTInterface { 
	private BNode root;
		
	public IntegerBST(){
		root = null; 
	}
	
	// Public Add operation
	public void add(int d){ 
		root = add(root,d);
	}
	// Private Add operation
	private BNode add(BNode rt, int d){
		if(rt == null)
		{ 
			// Root is null OR we have found the place to add 
			// the node create a new BNode and return 
			// it as the root of the tree
			
			return new BNode(d);
		}
		
		else if(d < rt.data())
		{ 
			// Need to add this value to left subtree
			// Call add recursuvely with r.left() & value
			// Once the recursuve call to add finsihes
			// we should have found the right position
			// and should have a new BNode to add
			
			// Set the left reference to the new node
			// and return rt
			BNode p = add(rt.left(), d);
			rt.setLeft(p);
			return rt;
		}
		
		else if(d > rt.data())
		{
			// Need to add this value to right subtree
			// Call add recursuvely with r.right() & value
			// Once the recursuve call to add finsihes
			// we should have found the right position
			// and should have a new BNode to add
			
			// Set the right reference to the new node
			// and return rt
			BNode p = add(rt.right(), d);
			rt.setRight(p);
			return rt;

		}
		
		else 
		{
			
			// Value d is already present in the tree
			// just return rt
			return rt;
		}
	}

	// Public version of Contains
	public boolean contains(int d){ 
		return contains(root, d);
	}
	
	// Private version of Contains	
	private boolean contains(BNode rt, int d){
		if(rt == null) 
			// If rt is null
			return false;
		else{
			if(rt.data() == d)
				// We found the data - return true
				return true; 
			else if(d < rt.data()){
				// value is < current node
				// Make recurive call to contains - traverse left subtree
				return contains(rt.left(), d);
			}
			else{
				// value is > current node
				// Make recurive call to contains - traverse right subtree
				return contains(rt.right(), d);
			}	
		} 
	}
	
	// Inorder
	public ArrayList inOrder(){ 
		ArrayList lst = new ArrayList(); 
		inOrder(root,lst);
		return lst;
	}
	
	private void inOrder(BNode rt, ArrayList lst){ 
		if(rt != null){
			inOrder(rt.left(), lst); //process left sub-tree
			lst.add(rt.data()); //process root
			inOrder(rt.right(),lst); //process right sub-tree
		} 
	}
	
	// Preorder
	public ArrayList preOrder(){ 
		ArrayList lst = new ArrayList(); 
		preOrder(root,lst);
		return lst;
	}
	
	private void preOrder(BNode rt, ArrayList lst){
		if(rt != null){
			lst.add(rt.data());//process root
			preOrder(rt.left(), lst);//process left sub-tree 
			preOrder(rt.right(), lst);//process right sub-tree
		} 
	}
	
	// Postorder
	public ArrayList postOrder(){ 
		ArrayList lst = new ArrayList(); 
		postOrder(root,lst);
		return lst;
	}
	
	private void postOrder(BNode rt, ArrayList lst){
		if(rt != null){
			postOrder(rt.left(), lst);//process left sub-tree 
			postOrder(rt.right(), lst);//process right-subtree 
			lst.add(rt.data());//process root
		} 
	}
	
	// Public Height  
	public int height(){
		return height(root);
	}
	private int height(BNode rt){
		if(rt == null) 
			return 0; 
		else{
			// Travel down the left and right subtree and count levels.
			return 1 + max(height(rt.left()),height(rt.right())); 
		}
	}
	// Compare the height of the right and left subtree
	private int max(int a,int b){ return a >= b? a:b;}
	
	/*
		Method remove implements the remove algorithm described. It begins by searching
		the tree for the given value x. There are two local variables ptr and its parent named
		parentPtr. When the search is complete ptr holds the reference to the node to be deleted
		and parentPtr references its immediate ancestor, if the search is successful. If the node to
		delete happens to be the root node then root may change. Hence, the assignment root =
		removeNode(root). If x is less than its parent node data the parent left sub-tree will change; 
		otherwise its right sub-tree changes.
	*/
	public void remove(int d){
		BNode ptr = null; 
		BNode parentPtr = null; 
		
		if(root != null){
			ptr = root; 	// Temp root ref
			parentPtr = root; // Ref to parent node

			boolean found = false; // Not found at start

			while(ptr != null && !found){ // Loop until found or full traversal
				if(ptr.data() == d) 
					found = true; 
				else{
					parentPtr = ptr; 	// Keep a ref to the parent node

					if(d < ptr.data())	// Decide what subtree to traverse
						ptr = ptr.left();
					else
						ptr = ptr.right(); 
				}
			} 
			
			// If we found the node, now we need to handle its removal
			if(found){
				
				if(ptr == root){
					root = removeNode(root);
				} 
				else{
					if(d < parentPtr.data()){
						BNode n = removeNode(parentPtr.left()); // left removal
						parentPtr.setLeft(n); 
					}
					else{ 
						BNode n = removeNode(parentPtr.right()); // right removal
						parentPtr.setRight(n);
					} 
				}
			} 
		}
	}
	
	/*
		The method removeNode returns a pointer to the parent node. If the node is a leaf node it returns null.
		If its left node reference is null then it returns the right node reference. If its right node reference
		is null then it returns the left node reference. In the case where both sub-trees are not null, it finds
		the rightmost node of the left sub-tree and uses its value to replace the element to be deleted. It then
		adjusts the appropriate pointer. There are two possible cases. If the replacement node is the child of 
		the parent then set parents, rt, left pointer to its left sub-tree, given by rt.setLeft(ptr.left()). 
		This occurs because the left node has no right sub- tree. Consider the diagram where the value to be 
		deleted is 10 and the replacement candidate value is 4. In this case the left pointer of the parent 
		node has to point to node with 2.
	*/
	private BNode removeNode(BNode rt){ 
		
		if(rt == null) // Node is null
			return null;
		else if (rt.left() == null && rt.right() == null) // Leaf node
			return null;
		else if (rt.left() == null) // No left child
			return rt.right(); 
		else if(rt.right() == null)  // No right child
			return rt.left();
		else {						 // Need to traverse subtree to find the right most node
			BNode ptr = rt.left(); 
			BNode parentPtr = null; 
			
			while(ptr.right() != null){
				parentPtr = ptr; 
				ptr = ptr.right(); 
			}
			
			rt.set(ptr.data());
			if(parentPtr == null) 			// parent did not move - root
				rt.setLeft(ptr.left());
			else
				parentPtr.setRight(ptr.left());	// Replace parent
			
			return rt; 
		}
	}

	
	

} // End class