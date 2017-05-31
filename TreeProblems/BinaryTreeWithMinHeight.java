package TreeProblems;

/**
 * This class provides the implementation to create a binary search tree of minimum height from an array with
 * elements in increasing order.
 */


public class BinaryTreeWithMinHeight {
	
	static class treeNode{
		int data;
		treeNode left;
		treeNode right;
		
		public treeNode(int data){
			this.data = data;
		}
	}

	//Helper method
	static treeNode createBst(int[] arr){
		return createBst(arr,0,arr.length -1);
	}

	//Method to create the bst with min height
	static treeNode createBst(int[] arr,int start, int end){
		
		if(end < start){
			return null;
		}
		
		int mid = (start + end)/2;
		
		treeNode n = new treeNode(arr[mid]);
		n.left = createBst(arr, start, mid-1);
		n.right = createBst(arr, mid+1, end);
		return n;
	}

	//Function to print the values of binary search tree in increasing order.
	static void inorder(treeNode root){
		if(root != null){
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		
		int[] arr = new int[]{1,4,7,9,11,15,18,20,34,56,79,80};		
		treeNode root = createBst(arr);
		inorder(root);
	}
}
