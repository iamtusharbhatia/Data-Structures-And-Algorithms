package GraphProblems;

/**
 * This class provides Breadth First Search traversal of all the nodes of a graph.
 */

import java.util.Iterator;
import java.util.LinkedList;

public class BfsTraversal {
	
	private int V; //No of vertices
	
	LinkedList<Integer> adj[]; //Adjacency matrix
	LinkedList<Integer> q = new LinkedList<Integer>();
	
	@SuppressWarnings("unchecked")
	public BfsTraversal(int v) {
		V =v;
		adj = new LinkedList[V];
		
		for(int i=0; i<V; i++){
			adj[i] = new LinkedList<Integer>();
		}
	}

	//This method adds edge to the graph.
	public void addEdge(int v, int w){
		adj[v].add(w);
	}

    //Method performing the traversal
	void bfsUtil(int v, boolean[] visited){
		
		visited[v] = true;
		q.add(v);
		
		while(!q.isEmpty()){
			int temp = q.removeFirst();
			System.out.println("Temp" + temp);
			
			Iterator<Integer> it = adj[temp].listIterator();
			while(it.hasNext()){
				int val = it.next();
				if(!visited[val]){
					System.out.println("Value added :"+ val);
					visited[val] = true;
					q.add(val);
				}
			}
		}
	}

    //Helper method
	void bfs(BfsTraversal b){
		boolean[] visited = new boolean[V];
		
		for(int i=0; i<V; i++){
			if(!visited[i]){
				bfsUtil(i,visited);
			}
		}
	}

	public static void main(String[] args) {
		
		BfsTraversal b = new BfsTraversal(4);
		
		b.addEdge(0, 1);
		b.addEdge(0, 2);
		b.addEdge(1, 0);
		b.addEdge(1, 3);
		b.addEdge(2, 3);
		b.addEdge(3, 0);
		
		b.bfs(b);
	}
}
