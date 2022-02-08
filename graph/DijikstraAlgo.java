package internship.graph;

import java.util.*;

// Requirements
/*'s Algorithm can only work with graphs that have positive weights. 
 * This is because, during the process, the weights of the edges have to be added to find the shortest path.
 */

/* If there is a negative weight in the graph, then the algorithm will not work properly. 
 * Once a node has been marked as "visited", the current path to that node is marked as the shortest path to reach that node. 
 * And negative weights can alter this if the total weight can be decremented after this step has occurred.
 */

public class DijikstraAlgo {
	
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
	
//	TC: O((V+E)logV) , SC: O(V)
	void shortestPath(int src,List<ArrayList<Node>> adj,int V) {
		int dist[] = new int[V];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((Node a,Node b) -> a.w - b.w);
		pq.add(new Node(src,0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int currVertex = curr.getV();
			for(Node temp : adj.get(currVertex)) {
				int newVertex = temp.getV();
				if(dist[currVertex] + temp.getWeight() < dist[newVertex]) {
					dist[newVertex] = dist[currVertex] + temp.getWeight();
					pq.add(new Node(newVertex,dist[newVertex]));
				}
			}
		}
		
		for(int i=0;i<V;i++) {
			System.out.print(dist[i] + " ");
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		
		int V = 5;
		List<ArrayList<Node>> adj = new ArrayList<>();
		
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<Node>());
		}
		
		adj.get(0).add(new Node(1,2));
		adj.get(1).add(new Node(0,2));
		
		adj.get(1).add(new Node(2,4));
		adj.get(2).add(new Node(1,4));
		
		adj.get(0).add(new Node(3,1));
		adj.get(3).add(new Node(0,1));
		
		adj.get(3).add(new Node(2,3));
		adj.get(2).add(new Node(3,3));
		
		adj.get(1).add(new Node(4,5));
		adj.get(4).add(new Node(1,5));
		
		adj.get(2).add(new Node(4,1));
		adj.get(4).add(new Node(2,1));
		
		DijikstraAlgo obj = new DijikstraAlgo();
		int src = 0;
		obj.shortestPath(src,adj,V);
	
	}

}
