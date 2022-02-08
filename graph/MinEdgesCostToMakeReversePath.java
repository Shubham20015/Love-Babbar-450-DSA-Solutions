package internship.graph;

import java.util.*;

public class MinEdgesCostToMakeReversePath {
	
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
	
	public static int shortestPath(int src,int dest,List<ArrayList<Node>> adj,int V) {
		int dist[] = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[src] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((Node a,Node b) -> a.w - b.w);
		pq.add(new Node(src,0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int currVertex = curr.getV();
			for(Node node : adj.get(currVertex)) {
				int newVertex = node.getV();
				if(dist[currVertex] + node.getWeight() < dist[newVertex]) {
					dist[newVertex] = dist[currVertex] + node.getWeight();
					pq.add(new Node(newVertex,dist[newVertex]));
				}
			}
		}
		
		return dist[dest];
	}
	
	public static List<ArrayList<Node>> modifiedGraph(int edges[][],int V,int E){
		
		List<ArrayList<Node>> adjList = new ArrayList<>();
		
		for(int i=0;i<V;i++) {
			adjList.add(new ArrayList<Node>());
		}
		
		for(int i=0;i<E;i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			adjList.get(u).add(new Node(v,0));
			adjList.get(v).add(new Node(u,1));
		}
		
		return adjList;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int edges[][] = new int[E][2];
		
		for(int i=0;i<E;i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
		}
		
		int src = sc.nextInt();
		int dest = sc.nextInt();
		
		List<ArrayList<Node>> adj = modifiedGraph(edges,V,E);
		
		System.out.println("Minimum edges to reverse to make path from " + src + " to " + dest + ": " + shortestPath(src,dest,adj,V));
		
		sc.close();
	}

}
