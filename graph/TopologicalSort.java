package internship.graph;

import java.util.*;

//  TC: O(V+E) , SC:O(V) + O(V) = O(V)
public class TopologicalSort {
	
	public static int[] BfsKahnAlgo(int V,List<ArrayList<Integer>> adjList) {
		int topo[] = new int[V];
		int indegree[] = new int[V];
		
		for(int i=0;i<V;i++) {
			for(int temp : adjList.get(i)) {
				indegree[temp]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0;i<V;i++) {
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		int index = 0;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			topo[index++] = curr;
			
			for(int val : adjList.get(curr)) {
				indegree[val]--;
				if(indegree[val] == 0) {
					queue.add(val);
				}
			}
		}
		
		return topo;
	}
	
	public static int[] DFSsort(int V,List<ArrayList<Integer>> adjList) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean visited[] = new boolean[V];
		
		for(int i=0;i<V;i++) {
			if(!visited[i]) {
				dfs(i,adjList,visited,stack);
			}
		}
		
		int topo[] = new int[V];
		int index = 0;
		
		while(!stack.isEmpty()) {
			topo[index++] = stack.pop();
		}
		
		return topo;
	}
	
	private static void dfs(int v,List<ArrayList<Integer>> adjList,boolean visited[],Stack<Integer> stack) {
		visited[v] = true;
		for(int val : adjList.get(v)) {
			if(!visited[val]) {
				dfs(val,adjList,visited,stack);
			}
		}
		stack.push(v);
	}
}
