/*
 * This class represents a binary search tree, where every Node has two children,
 * the left child must contain a smaller value, and the right child must contain a 
 * larger value. 
 * This binary search tree is unique as it can be converted into a linked list.
 * 
 * Mark Guan
 * May 21, 2014
 */

public class Tree {

	private TreeNode root;
	
	//default constructor
	//coded in for readability
	public Tree(){
		root = null;
	}
	
	//will add a new TreeNode to the tree which contains the given integer
	public void add(Integer integer){
		add(new TreeNode(integer));
	}
	
	//helper method which takes in a TreeNode and adds it to the tree
	private void add(TreeNode node){	
		if (root == null) {
			root = node;
		} else {
			TreeNode current = root;
			TreeNode parent;
			while (true) {
				parent = current;
				if (node.getValue() <= current.getValue()) {
					current = current.getLeft();
					if (current == null) {
						parent.setLeft(node);
						return; 
					}
				} else {
					current = current.getRight();
					if (current == null) {
						parent.setRight(node);
						return; 
					}
				}
			}
		}
	}
	
	//returns whether or not a given integer is contained inside a node in the tree
	public boolean contains(Integer integer) {
		return contains(root, integer);
	}
	
	//helper method which takes a node to check
	private boolean contains(TreeNode treeNode, Integer integer) {
		if(treeNode.getValue().equals(integer)){
			return true;
		}
		if(treeNode.getLeft() == null && treeNode.getRight() == null){
			return false;
		}
		
		if(integer > treeNode.getValue()){
			if(treeNode.getRight() != null)
				return contains(treeNode.getRight(),  integer);
		}
		else{
			if(treeNode.getLeft() != null)
				return contains(treeNode.getLeft(),  integer);
		}
		
		return false;
	}
	
	//returns the in Order traversal of the tree
	//first gets the left child, then the node, then the right child
	public String toString(){
		return toString(root);
	}
	//helper method which takes in a TreeNode
	private String toString(TreeNode current) {
		if(current == null)
			return "";

		return toString(current.getLeft()) + " " + current.getValue() + " " + toString(current.getRight());

	}

	//returns the pre Order traversal of the tree
	//first gets the node, then the left child, then the right child
	public String preOrderToString(){
		return preOrderToString(root);
	}
	//helper method which takes in a TreeNode
	private String preOrderToString(TreeNode current) {

		if(current == null)
			return "";

		return current.getValue() + " " + preOrderToString(current.getLeft()) + " " + preOrderToString(current.getRight());
	}
	
	//returns the post Order traversal of the tree
	//first gets the left child, then the right child, then gets the node
	public String postOrderToString(){
		return postOrderToString(root);
	}
	private String postOrderToString(TreeNode current) {

		if(current == null)
			return "";

		return postOrderToString(current.getLeft()) + " " + postOrderToString(current.getRight()) + " " + current.getValue();
	}


	 
	 
	 //---------------------------------------Tree to List -----------------------------
	 
	 //takes in the head nodes for two circular doubly linked lists
	 //links the two lists together
	 //will return the head node of the new list
	 public TreeNode joinLists(TreeNode a, TreeNode b) { 
	    if(a == null)return b;
	    if(b == null)return a;
	    
	    TreeNode aLast = a.getLeft();
	    TreeNode bLast = b.getLeft();
	    
	    
	    aLast.setRight(b);
	    b.setLeft(aLast);
	    
	    bLast.setRight(a);
	    a.setLeft(bLast);
	    
	    return a;
    }

    //turns the binary search tree to a doubly-linked circular list
	//The root node of the tree class will become the 'head' node of the list
	//The 'left' field of a node will be the 'previous' field of a list node and the 'right' will become the 'next'
    public void treeToList(){
    	root = treeToList(root);
    }
    
    // a helper method which takes in a node, and returns the head node of the new list
    private TreeNode treeToList(TreeNode node) {
       if(node == null){
    	   return null;
       }
      
       TreeNode leftSide = treeToList(node.getLeft());
       TreeNode rightSide = treeToList(node.getRight());
    	
       //the joinLists method takes in circular linked lists so the node
       //itself must be made into a circular linked list
       node.setLeft(node);
       node.setRight(node);
       
       TreeNode leftSideandNode = joinLists(leftSide, node);
       TreeNode completeList = joinLists(leftSideandNode, rightSide);
    	      	    	   
       return completeList;
       
    }
    
    //prints out every element in the transformed list
    public void printList() {
        TreeNode current = root;
        
        while (current != null) {
            System.out.print(Integer.toString(current.getValue()) + " ");
            current = current.getRight();
            if (current == root) break;
        }
        
        System.out.println();
    }

	 
	//test code
    public static void main( String [] args){
    	Tree bsTree = new Tree();
	bsTree.add(new Integer(5));
	bsTree.add(new Integer(3));
	bsTree.add(new Integer(4));
	bsTree.add(new Integer(1));
	bsTree.add(new Integer(8));
	bsTree.add(new Integer(-2));

	bsTree.treeToList();
	bsTree.printList();
    }
	
}
