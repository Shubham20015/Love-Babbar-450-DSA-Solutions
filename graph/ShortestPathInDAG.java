package internship.graph;

import java.util.*;

public class ShortestPathInDAG {
	
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
	
	public int[] shortestPath(int src,List<ArrayList<Pair>> adjList,int V) {
		Stack<Integer> stack = topologicalSort(V, adjList);
		int dist[] = new int[V];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		
		while(!stack.isEmpty()) {
			int node  = stack.pop();
			
			if(dist[node] != Integer.MAX_VALUE) {
				for(Pair temp : adjList.get(node)) {
					if(dist[node] + temp.getWeight() < dist[temp.getV()]) {
						dist[temp.getV()] = dist[node] + temp.getWeight();
					}
				}
			}
		}
		
		return dist;
	}
	
	private static Stack<Integer> topologicalSort(int V,List<ArrayList<Pair>> adjList) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[V];
		
		for(int i=0;i<V;i++) {
			if(!visited[i]) {
				dfs(i,adjList,visited,stack);
			}
		}
		
		return stack;
	}
	
	private static void dfs(int v,List<ArrayList<Pair>> adjList,boolean visited[],Stack<Integer> stack) {
		visited[v] = true;
		for(Pair val : adjList.get(v)) {
			int currVetrex = val.getV();
			if(!visited[currVetrex]) {
				dfs(currVetrex,adjList,visited,stack);
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
		
		adj.get(0).add(new Pair(1,2));
		adj.get(0).add(new Pair(4,1));
		adj.get(1).add(new Pair(2,3));
		adj.get(2).add(new Pair(3,6));
		adj.get(4).add(new Pair(2,2));
		adj.get(4).add(new Pair(5,4));
		adj.get(5).add(new Pair(3,1));
		
		
		ShortestPathInDAG obj = new ShortestPathInDAG();
		int src = 0;
		int ans[] = obj.shortestPath(src,adj,V);
		
		for(int x : ans) {
			System.out.print(x + " ");
		}
	
	}
}
