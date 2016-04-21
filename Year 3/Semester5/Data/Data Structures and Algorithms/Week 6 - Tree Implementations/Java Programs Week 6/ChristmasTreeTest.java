class ChristmasTreeTest{
   public static void main(String[]args){

	BinaryTree t1 = new BinaryTree();
    t1.setRootItem("W");
    t1.attachLeft("Q");

    BinaryTree tL = new BinaryTree();
    tL.setRootItem("K");
    tL.attachLeft("H");
    tL.attachRightSubtree(t1);


    BinaryTree t2 = new BinaryTree();
    t2.setRootItem("P");
    t2.attachLeft("V");
    t2.attachRight("A");

    BinaryTree tR = new BinaryTree();
    tR.setRootItem("O");
    tR.attachRightSubtree(t2);

    BinaryTree JTree = new BinaryTree("J",tL, tR);


    /*
    BinaryTree t1 = new BinaryTree();

    t1.setRootItem("l");
    t1.attachLeft("o");
    t1.attachRight("w");

    BinaryTree tL = new BinaryTree("e");
    tL.attachLeft("l");
    tL.attachRightSubtree(t1);

    BinaryTree t2 = new BinaryTree("l");
	t2.attachRight("d");

	BinaryTree tR = new BinaryTree("o");
	tR.attachLeft("r");
	tR.attachRightSubtree(t2);

	BinaryTree treeChristmas = new BinaryTree("h", tL, tR);
    */


    TreeIterator i = new TreeIterator(JTree);

    //i.setPreorder();
    //System.out.println();

    //i.setPostorder();
    //System.out.println();

    i.setInorder();
	System.out.println();

   }

}