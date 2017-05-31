package TreeProblems;

/**
 * This class provides the methods which create a linked list for each level of a binary tree using both BFS and
 * DFS.
 */

import java.util.ArrayList;
import java.util.LinkedList;


public class LinkedListFromBinaryTree {
	
	static class treeNode{
		int data;
		treeNode left;
		treeNode right;
		
		public treeNode(int data) {
			this.data = data;
		}
	}

    //This method creates linkedLists for every level of the tree using DFS
	public static void createLinkedListDFS(treeNode root, ArrayList<LinkedList<treeNode>> lists ,int level){
		
		if(root == null){
			return;
		}
		
		LinkedList<treeNode> list;
		if(lists.size() == level){
			list = new LinkedList<>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		
		list.add(root);
		createLinkedListDFS(root.left, lists, level+1);
		createLinkedListDFS(root.right, lists, level+1);
	}

	//Helper method
	public static ArrayList<LinkedList<treeNode>> createLinkedListDFS(treeNode root){
		ArrayList<LinkedList<treeNode>> lists = new ArrayList<LinkedList<treeNode>>();
		createLinkedListDFS(root,lists,0);
		return lists;
	}

	//This method creates linkedLists for every level of the tree using BFS
	public static ArrayList<LinkedList<treeNode>> createLinkedListBFS(treeNode root){
		
		if(root == null){
			return null;
		}
		
		ArrayList<LinkedList<treeNode>> result = new ArrayList<LinkedList<treeNode>>();
		LinkedList<treeNode> current = new LinkedList<LinkedListFromBinaryTree.treeNode>();
		current.add(root);
		LinkedList<treeNode> parents;
		
		while(!current.isEmpty()){
			result.add(current);
			
			parents = current;
			current = new LinkedList<>();
			
			for (treeNode node : parents){
				if(node.left != null){
					current.add(node.left);
				}
				if(node.right != null){
					current.add(node.right);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		treeNode n = new treeNode(8);
		n.left = new treeNode(5);
		n.right = new treeNode(10);
		n.left.left = new treeNode(1);
		n.left.right = new treeNode(6);
		n.right.left = new treeNode(9);
		n.right.right = new treeNode(12);
		
		ArrayList<LinkedList<treeNode>> dfsObj = createLinkedListDFS(n);		
		System.out.println("Output using DFS");
		for (LinkedList<treeNode> linkedList : dfsObj) {
			for (treeNode treeNode : linkedList) {
				System.out.print(treeNode.data+ " ");
			}
			System.out.println();
		}
		
		ArrayList<LinkedList<treeNode>> bfsObj = createLinkedListBFS(n);
		System.out.println("Output using BFS");
		for (LinkedList<treeNode> linkedList : bfsObj) {
			for (treeNode treeNode : linkedList) {
				System.out.print(treeNode.data+ " ");
			}
			System.out.println();
		}
	}
}
