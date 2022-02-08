package internship.graph;

import java.util.*;

public class DijikstraWithUnitWeightedGraph {
	
//	TC: O((V+E) , SC: O(V) + O(V) (dist array and queue)
	static void shortestPath(int src,List<ArrayList<Integer>> adj,int V) {
		int dist[] = new int[V];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int temp : adj.get(curr)) {
				if(dist[curr] + 1 < dist[temp]) {
					dist[temp] = dist[curr] + 1;
					q.add(temp);
				}
			}
		}
		
		for(int i=0;i<V;i++) {
			System.out.print(dist[i] + " ");
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		
		int V = 9;
		List<ArrayList<Integer>> adj = new ArrayList<>();
		
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<>());
		}
		
		adj.get(0).add(1);
		adj.get(0).add(3);
		
		adj.get(1).add(0);
		adj.get(1).add(2);
		adj.get(0).add(3);
		
		adj.get(2).add(1);
		adj.get(2).add(6);
		
		adj.get(3).add(0);
		adj.get(3).add(4);
		
		adj.get(4).add(3);
		adj.get(4).add(5);
		
		adj.get(5).add(4);
		adj.get(5).add(6);
		
		adj.get(6).add(2);
		adj.get(6).add(5);
		adj.get(6).add(7);
		adj.get(6).add(8);
		
		
		adj.get(7).add(6);
		adj.get(7).add(8);
		
		adj.get(8).add(6);
		adj.get(8).add(7);
		
		int src = 0;
		shortestPath(src,adj,V);
	
	}
}
