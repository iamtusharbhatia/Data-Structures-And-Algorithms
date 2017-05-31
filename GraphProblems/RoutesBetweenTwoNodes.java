package GraphProblems;

/**
 * This class provides the method which will tells if there exists some route between two given nodes.
 */

import java.util.Iterator;
import java.util.LinkedList;

public class RoutesBetweenTwoNodes {
	
	static int V;
	
	static class graph{
		
		LinkedList<Integer>[] adj;
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		public graph(int v){
			V =v;
			adj = new LinkedList[V];
			
			for(int i=0; i<V; i++){
				adj[i] = new LinkedList<>();
			}
		}
		
		void addEdge(int v, int w){
			adj[v].add(w);
		}
	}

	//This method tells if route exists between 2 given nodes or not.
	public static boolean routes(graph g, int s, int end){
		
		if(s == end){
			return true;
		}
		
		boolean[] visited = new boolean[V];
		
		visited[s] = true;
		g.q.add(s);
		
		while(!g.q.isEmpty()){
			int temp = g.q.removeFirst();
			Iterator<Integer> it = g.adj[temp].listIterator();
			while(it.hasNext()){
				int next = it.next();
				if(!visited[next]){
					visited[next] = true;
					g.q.add(next);
					if(next == end){
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
		graph g = new graph(5);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 0);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		g.addEdge(3, 4);
		g.addEdge(4, 4);
		
		if(routes(g, 1, 2)){
			System.out.println("Route exist");
		}else {
			System.out.println("Route doesn't exist");
		}
	}
}
