/*
 * This class represents a Binary search tree node, it contains an integer value
 * it points to two children,
 * the left child must contain a smaller value, and the right child must contain a 
 * larger value;
 * 
 * Mark Guan
 * Period 6
 * May 21, 2014
 */

public class TreeNode {
	
	private TreeNode left;
	private TreeNode right;
	private Integer value;
	
	//constructor
	//takes in an Integer value
	//the left and right children are still null
	public TreeNode(Integer value){
		this.value = value;
	}
	
	//constructor
	//takes in an Integer value and a left node and a right node
	public TreeNode(Integer v, TreeNode l, TreeNode r){
		value = v;
		left = l;
		right = r;		
	}
	
	//gets and returns the Integer value
	public Integer getValue(){return value;}
	//gets and returns the left TreeNode
	public TreeNode getLeft(){return left;}
	//gets and returns the right TreeNode
	public TreeNode getRight(){return right;}
	
	//takes in an Integer value and sets it to the node's value
	public void setValue(Integer i){value = i;}
	//takes in a TreeNode and sets it to the node's left child
	public void setLeft(TreeNode left){this.left = left;} 
	//takes in a TreeNode and sets it to the node's right child
	public void setRight(TreeNode right){this.right = right;} 

}