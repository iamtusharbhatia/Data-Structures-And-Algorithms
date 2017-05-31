package TreeProblems;

/**
 * This class provides traversal of trees in InOrder, PreOrder, PostOrder.
 */

public class TreeTraversal {
	
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int data) {
			this.data = data; 
		}
	}
	
	static void inorder(TreeNode root){
		if(root != null){
			inorder(root.left);
			visit(root);
			inorder(root.right);
		}
	}
	
	static void preorder(TreeNode root){
		if(root != null){
			visit(root);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	static void postorder(TreeNode root){
		if(root != null){
			postorder(root.left);
			postorder(root.right);
			visit(root);
		}
	}
	
	static void visit(TreeNode node){
		System.out.println(node.data);
	}
	

	public static void main(String[] args) {

		TreeNode obj = new TreeNode(30);
		obj.left = new TreeNode(20);
		obj.right = new TreeNode(40);
		obj.left.left = new TreeNode(15);
		obj.left.right = new TreeNode(25);
		obj.right.left = new TreeNode(35);
		obj.right.right = new TreeNode(45);
		System.out.println("In order");
		inorder(obj);
		System.out.println("Pre order");
		preorder(obj);
		System.out.println("Post order");
		postorder(obj);
	}
}
