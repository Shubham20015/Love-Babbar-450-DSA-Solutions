package internship.graph;

import java.util.*;

public class CliqueProblem {
	
	static boolean flag = false;
	
	private static void bipartite(int src,int parent,int color[],List<ArrayList<Integer>> revertAdj) {
		color[src] = 1;
		for(int v : revertAdj.get(src)) {
			if(color[v] == -1) {
				color[v] = 1 - color[src];
				bipartite(v,src,color,revertAdj);
			}else if(v != parent && color[src] == color[v]) {
				flag = true;
				break;
			}
		}
	}
	
	public static boolean isClique(int V,List<ArrayList<Integer>> adj) {
		List<ArrayList<Integer>> revertAdj = new ArrayList<>();
		boolean dummy[] = new boolean[V];
		
		for(int i=0;i<V;i++) {
			revertAdj.add(new ArrayList<>());
		}
		
		for(int i=0;i<V;i++) {
			dummy[i] = true;
			for(int j : adj.get(i)) {
				dummy[j] = true;
			}
			for(int j=0;j<V;j++) {
				if(!dummy[j]) {
					revertAdj.get(i).add(j);
					revertAdj.get(j).add(i);
				}
			}
		}
		
		int color[] = new int[V];
		Arrays.fill(color, -1);
		
		bipartite(0,-1,color,revertAdj);
		
		return flag;
	}

	public static void main(String[] args) {
		int V = 5;
		List<ArrayList<Integer>> adj = new ArrayList<>();
		
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<>());
		}
		
		adj.get(0).add(1);
		adj.get(1).add(0);
		
		adj.get(1).add(2);
		adj.get(2).add(1);
		
		adj.get(0).add(2);
		adj.get(2).add(0);
		
		adj.get(0).add(3);
		adj.get(3).add(0);
		
		adj.get(3).add(4);
		adj.get(4).add(3);
		
		System.out.println(isClique(V,adj) ? "Not Possible" : "Two Clique");
	}
}
