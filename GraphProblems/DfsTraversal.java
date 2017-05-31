package GraphProblems;

/**
 * This class provides Depth First Search traversal of all the nodes of a graph.
 */

import java.util.Iterator;
import java.util.LinkedList;

public class DfsTraversal {
	
	private int V;
	
	LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	public DfsTraversal(int v) {
		V=v;
		adj = new LinkedList[V];
		for(int i=0; i<V; i++){
			adj[i] = new LinkedList<Integer>();
		}
	}

    //This method adds edge to the graph.
	void addEdge(int v, int w){
		adj[v].add(w);
	}

	//Helper method
	void dfs(){
		boolean visited[] = new boolean[V];
		for(int i=0; i<V; i++){
			if(!visited[i]){
				dfsUtil(i,visited);
			}
		}
	}

	//Method performing the traversal
	void dfsUtil(int v, boolean[] visited){
		
		visited[v] = true;
		System.out.print(v+ " ");
		
		Iterator<Integer> it = adj[v].listIterator();
		
		while(it.hasNext()){
			int temp = it.next();
			if(!visited[temp]){
				dfsUtil(temp, visited);
			}
		}
	}

	public static void main(String[] args) {
		
		DfsTraversal d = new DfsTraversal(4);
		
		d.addEdge(0, 1);
		d.addEdge(0, 2);
		d.addEdge(1, 0);
		d.addEdge(1, 3);
		d.addEdge(2, 3);
		d.addEdge(3, 0);
		
		d.dfs();
	}
}
