package internship.graph;

import java.util.*;

public class JourneyToMoon {
	
	private static void dfs(int v,List<ArrayList<Integer>> adj,boolean visited[]) {
		visited[v] = true;
		vertices++;
		for(int node : adj.get(v)) {
			if(!visited[node]) {
				dfs(node,adj,visited);
			}
		}
	}
	
	static int vertices;
	
	public static int totalPairs(int V,List<ArrayList<Integer>> adj) {
		boolean visited[] = new boolean[V];
		int ans = V*(V-1)/2;
		for(int i=0;i<V;i++) {
			if(!visited[i]) {
				vertices = 0;
				dfs(i,adj,visited);
				ans -= vertices*(vertices-1)/2;
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		int V = 5;
		List<ArrayList<Integer>> adj = new ArrayList<>();
		
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<>());
		}
		
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(2).add(3);
		adj.get(3).add(2);
		adj.get(0).add(4);
		adj.get(4).add(0);
		
		System.out.println("Total Combinations: " + totalPairs(V, adj));

	}

}
