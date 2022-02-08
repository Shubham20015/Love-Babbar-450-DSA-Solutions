package internship.graph;

import java.util.*;

public class ArticulationPoint {
//	TC: O(V+E) , SC: O(V)
	private void dfs(int v,int parent,boolean visited[],int tin[],int low[],int isArticulation[],List<ArrayList<Integer>> adj,int timer) {
		visited[v] = true;
		tin[v] = low[v] = timer++;
		
		int child = 0;
		for(int node : adj.get(v)) {
			if(node == parent) continue;
			
			if(!visited[node]) {
				dfs(node,v,visited,tin,low,isArticulation,adj,timer);
				low[v] = Math.min(low[v],low[node]);
				
				if(low[node] >= tin[v] && parent != -1) {
					isArticulation[v] = 1;
				}
				child++;
			}else {
				low[v] = Math.min(low[v],tin[node]);
			}
		}
		
		if(parent != -1 && child > 1) isArticulation[v] = 1;
	}
	
	public void printCutVertexPoints(List<ArrayList<Integer>> adj,int V) {
		boolean visited[] = new boolean[V];
		int tin[] = new int[V];
		int low[] = new int[V];
		
		int isArticulation[] = new int[V];
		
		int timer = 0;
		for(int i=0;i<V;i++) {
			if(!visited[i]) {
				dfs(i,-1,visited,tin,low,isArticulation,adj,timer);
			}
		}
		
		for(int i=0;i<V;i++)
			if(isArticulation[i] == 1)
				System.out.println(i);
	}
	
	public static void main(String[] args) {
			
			int V = 5;
			List<ArrayList<Integer>> adj = new ArrayList<>();
			
			for(int i=0;i<V;i++) {
				adj.add(new ArrayList<>());
			}
			
			adj.get(0).add(1);
			adj.get(1).add(0);
			
			adj.get(0).add(2);
			adj.get(2).add(0);
			
			adj.get(1).add(2);
			adj.get(2).add(1);
			
			adj.get(1).add(3);
			adj.get(3).add(1);
			
			adj.get(3).add(4);
			adj.get(4).add(3);
			
			ArticulationPoint obj = new ArticulationPoint();
			obj.printCutVertexPoints(adj,V);
		
	}
}
