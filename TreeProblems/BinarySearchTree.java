package TreeProblems;

/**
 * This class provides the implementation to create a binary search tree and also to check if a tree is BST.
 */


public class BinarySearchTree {
	
	Node root;

	//Method to create a BST manually
	void createTree(){
		root = new Node(4,new Node(2, new Node(-1), new Node(3)),new Node(6, new Node(5), new Node(70)));
	}

	//Method to insert values in a BST
	void insertNode(Node node) {

		Node curr = root;

		while(curr.left != null || curr.right != null){
			if(curr.data <= node.data){
				if(curr.right == null) break;
				curr = curr.right;
			} else {
				if(curr.left == null) break;
				curr = curr.left;
			}
		}

		if(curr.data <= node.data){
			curr.right = node;
		} else {
			curr.left = node;
		}
	}

	//Helper Method
	boolean isBinarySearchtree(){
		return(isBinarySearchtree(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	//This method tells us if the tree is a BST or not.
	boolean isBinarySearchtree(Node root, int min, int max){
		
		if(root == null){
			return true;
		}
		if(root.data < min || root.data > max){
			return false;
		}
		return isBinarySearchtree(root.left, min, root.data) && isBinarySearchtree(root.right, root.data, max);
	}
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			left = null;
			right = null;
		}
		
		Node(int data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

    //Function to print the values of binary search tree in increasing order.
    void inorder(Node traverse){
		if(traverse != null){
			inorder(traverse.left);
			visit(traverse);
			inorder(traverse.right);
		}
	}

	void inorder(){
		inorder(root);
	}

	static void visit(Node node){
		System.out.println(node.data);
	}
	
	public static void main(String[] args) {	

		BinarySearchTree obj = new BinarySearchTree();

		obj.root = new Node(10);
		obj.insertNode(new Node(5));
		obj.insertNode(new Node(15));
		obj.insertNode(new Node(20));
		obj.insertNode(new Node(18));
		obj.insertNode(new Node(6));
		obj.inorder();
		//obj.createTree();
		System.out.println(obj.isBinarySearchtree());
	}
}
