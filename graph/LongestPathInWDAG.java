package internship.graph;

import java.util.*;

public class LongestPathInWDAG {
	
	static class Pair{
		int v,w;
		Pair(int _v,int _w){
			v = _v;
			w = _w;
		}
		
		int getV() {
			return v;
		}
		
		int getWeight() {
			return w;
		}
	}
	
	public int[] longestPath(int src,List<ArrayList<Pair>> adj,int V) {
		boolean visited[] = new boolean[V];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<V;i++) {
			if(!visited[i]) {
				dfs(i,adj,visited,stack);
			}
		}
		
		int dist[] = new int[V];
		Arrays.fill(dist, Integer.MIN_VALUE);
		dist[src] = 0;
		
		while(!stack.isEmpty()) {
			int u = stack.pop();
			
			if(u != Integer.MIN_VALUE) {
				for(Pair node : adj.get(u)) {
					int v = node.getV();
					int weight = node.getWeight();
					if(dist[v] < dist[u] + weight) {
						dist[v] = dist[u] + weight;
					}
				}
			}
		}
		
		return dist;
	}
	
	private void dfs(int v,List<ArrayList<Pair>> adj,boolean visited[],Stack<Integer> stack) {
		visited[v] = true;
		
		for(Pair node : adj.get(v)) {
			int currVertex = node.getV();
			if(!visited[currVertex]) {
				dfs(currVertex,adj,visited,stack);
			}
		}
		
		stack.push(v);
	}

	public static void main(String[] args) {
		int V = 6;
		List<ArrayList<Pair>> adj = new ArrayList<>();
		
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<>());
		}
		
		adj.get(0).add(new Pair(1,5));
		adj.get(0).add(new Pair(2,3));
		adj.get(1).add(new Pair(3,6));
		adj.get(1).add(new Pair(2,2));
		adj.get(2).add(new Pair(4,4));
		adj.get(2).add(new Pair(5,2));
		adj.get(2).add(new Pair(3,7));
		adj.get(3).add(new Pair(5,1));
		adj.get(3).add(new Pair(4,-1));
		adj.get(4).add(new Pair(5,-2));
		
		
		LongestPathInWDAG obj = new LongestPathInWDAG();
		int src = 1;
		int ans[] = obj.longestPath(src,adj,V);
		
		for(int x : ans) {
			System.out.print((x == Integer.MIN_VALUE ? "INF":x) + " ");
		}

	}

}
