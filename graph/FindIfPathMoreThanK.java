package internship.graph;

import java.util.*;

public class FindIfPathMoreThanK {
	
	static class Node{
		int v,w;
		Node(int _v,int _w){
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
	
//	TC: O(V!) , SC: O(V)
	public boolean isPossible(int V,int src,int k,List<ArrayList<Node>> adj) {
		boolean visited[] = new boolean[V];
		visited[src] = true;
		return pathGreaterThanK(adj,visited,src,k);
	}
	
	private boolean pathGreaterThanK(List<ArrayList<Node>> adj,boolean visited[],int src,int k) {
		if(k <= 0)
			return true;
		
		for(Node it : adj.get(src)) {
			
			int currVertex = it.getV();
			int currWeight = it.getWeight();
			
			if(visited[currVertex])
				continue;
			
			if(currWeight >= k)
				return true;
			
			visited[currVertex] = true;
			
			if(pathGreaterThanK(adj,visited,currVertex,k-currWeight)) return true;
			
			visited[currVertex] = false;
		}
		
		return false;
	}
	
	public static void addEdge(int u,int v,int w,List<ArrayList<Node>> adj) {
		adj.get(u).add(new Node(v,w));
		adj.get(v).add(new Node(u,w));
	}

	public static void main(String[] args) {
		int V = 9;
		List<ArrayList<Node>> adj = new ArrayList<>();
		
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<Node>());
		}
		

		addEdge(0, 1, 4,adj);
	    addEdge(0, 7, 8,adj);
	    addEdge(1, 2, 8,adj);
	    addEdge(1, 7, 11,adj);
	    addEdge(2, 3, 7,adj);
	    addEdge(2, 8, 2,adj);
	    addEdge(2, 5, 4,adj);
	    addEdge(3, 4, 9,adj);
	    addEdge(3, 5, 14,adj);
	    addEdge(4, 5, 10,adj);
	    addEdge(5, 6, 2,adj);
	    addEdge(6, 7, 1,adj);
	    addEdge(6, 8, 6,adj);
	    addEdge(7, 8, 7,adj);
		
		FindIfPathMoreThanK obj = new FindIfPathMoreThanK();
		
		int src = 0,k = 60;
		boolean ans = obj.isPossible(V,src,k,adj);
		System.out.println(ans);

	}

}
