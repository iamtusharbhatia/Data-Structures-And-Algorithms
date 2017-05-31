package GraphProblems;

/**
 * This class provides the method which will tell if a graph is strongly connected or not.
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class StronglyConnectedGraph {

	int V;
	LinkedList<Integer>[] adj;
	LinkedList<Integer> q = new LinkedList<Integer>();

	public StronglyConnectedGraph(int v) {
		V = v;
		adj = new LinkedList[V];

		for(int i=0; i<V; i++){
			adj[i] = new LinkedList<>();
		}
	}

    //Function to add an edges to the graph
	public void addEdge(int x, int y){
		adj[x].add(y);
	}

	//Function to check whether a node is connected to all other nodes.
	public boolean stronglyConnected(boolean[] visited, int start){

		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()){
			int temp = q.removeFirst();
			Iterator<Integer> it = adj[temp].listIterator();

			while(it.hasNext()){
				int val = it.next();
				if(!visited[val]){
					visited[val] = true;
					q.add(val);
				}
			}
		}

		for(int i=0; i<V; i++){
			if(!visited[i]) return false;
		}
		return true;
	}

    // Function that returns transpose of the original graph
    public StronglyConnectedGraph getTranspose() {
        StronglyConnectedGraph g = new StronglyConnectedGraph(V);
        for (int i = 0; i < V; i++)
        {
            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> it = adj[i].listIterator();
            while (it.hasNext())
                g.adj[it.next()].add(i);
        }
        return g;
    }

	public void BfsUtil(){

		boolean[] visited = new boolean[V];

		if(stronglyConnected(visited,0)){
            StronglyConnectedGraph gr = getTranspose();
			Arrays.fill(visited, false);

			if(gr.stronglyConnected(visited, 0)){
				System.out.println("Graph is strongly connected");
			} else {
				System.out.println("Graph is not strongly connected");
			}
		} else {
			System.out.println("Graph is not strongly connected");
		}
	}

	public static void main(String[] args) {

		StronglyConnectedGraph g = new StronglyConnectedGraph(5);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		g.addEdge(2, 4);
		g.addEdge(4, 2);
		g.BfsUtil();

        StronglyConnectedGraph g2 = new StronglyConnectedGraph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.BfsUtil();
	}
}
