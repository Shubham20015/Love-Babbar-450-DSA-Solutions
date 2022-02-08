package internship.graph;

import java.util.*;

// This is NP problem so it has not any particular polynomial solution(maybe differ in answers)
public class VertexCoverProblem {
	
	public static void printVertexCover(int V,List<ArrayList<Integer>> adj) {
		boolean visited[] = new boolean[V];
		
		for(int u=0;u<V;u++) {
			if(!visited[u]) {
				for(int v : adj.get(u)) {
					if(!visited[v]) {
						visited[u] = true;
						visited[v] = true;
						break;
					}
				}
			}
		}
		
		for(int i=0;i<V;i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
	}
	
	public static void addEdge(int u,int v,List<ArrayList<Integer>> adj) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	public static void main(String[] args) {
		int V = 9;
		List<ArrayList<Integer>> adj = new ArrayList<>();
		
		for(int i=0;i<V;i++)
			adj.add(new ArrayList<>());
		
		addEdge(0, 1,adj);
		addEdge(2, 3,adj);
		addEdge(1, 2,adj);
		addEdge(1, 4,adj);
      	addEdge(2, 4,adj);
		addEdge(6, 7,adj);
		addEdge(1, 6,adj);
      	addEdge(7, 4,adj);
		addEdge(7, 8,adj);
		addEdge(3, 8,adj);
      	addEdge(3, 5,adj);
		addEdge(8, 5,adj);
		
		printVertexCover(V,adj);
		
	}

}
