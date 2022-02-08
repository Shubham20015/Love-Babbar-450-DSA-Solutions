package internship.graph;

import java.util.*;

public class PrimsAlgo {
	
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
	
//	TC: O(V*(V + E)) , SC: O(V) + O(V) + O(V) = O(V)
	public void MST(List<ArrayList<Node>> adj,int V) {
		int key[] = new int[V];
		int parent[] = new int[V];
		boolean MSTarr[] = new boolean[V];
		
		Arrays.fill(key, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		Arrays.fill(MSTarr, false);
		key[0] = 0;
		
		for(int i=0;i<V-1;i++) {
			
			int min = Integer.MAX_VALUE,u = 0;
			
			for(int v=0;v<V;v++) {
				if(!MSTarr[v] && key[v] < min) {
					min = key[v];
					u = v;
				}
			}
			
			MSTarr[u] = true;
			
			for(Node temp : adj.get(u)) {
				int currVertex = temp.getV();
				int currWeight = temp.getWeight();
				
				if(!MSTarr[currVertex] && currWeight < key[currVertex]) {
					parent[currVertex] = u;
					key[currVertex] = currWeight;
				}
			}
		}
		
		for(int i=1;i<V;i++)
			System.out.println(parent[i] + " -> " + i);
	}
	
//	TC: O(V*logV) , SC: O(V)
	public void EfficientMST(List<ArrayList<Node>> adj,int V) {
		int key[] = new int[V];
		int parent[] = new int[V];
		boolean MSTarr[] = new boolean[V];
		
		Arrays.fill(key, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		Arrays.fill(MSTarr, false);
		key[0] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>((Node a,Node b) -> a.w - b.w);
		pq.add(new Node(0,key[0]));
	
		for(int i=0;i<V-1;i++) {
			
			int u = pq.poll().getV();
			
			MSTarr[u] = true;
			
			for(Node temp : adj.get(u)) {
				int currVertex = temp.getV();
				int currWeight = temp.getWeight();
				
				if(!MSTarr[currVertex] && currWeight < key[currVertex]) {
					parent[currVertex] = u;
					key[currVertex] = currWeight;
					pq.add(new Node(currVertex,key[currVertex]));
				}
			}
		}
		
		for(int i=1;i<V;i++)
			System.out.println(parent[i] + " -> " + i);
	}

	public static void main(String[] args) {
		int V = 5;
		List<ArrayList<Node>> adj = new ArrayList<>();
		
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<Node>());
		}
		
		adj.get(0).add(new Node(1,2));
		adj.get(1).add(new Node(0,2));
		
		adj.get(1).add(new Node(2,3));
		adj.get(2).add(new Node(1,3));
		
		adj.get(0).add(new Node(3,6));
		adj.get(3).add(new Node(0,6));
		
		adj.get(1).add(new Node(3,8));
		adj.get(3).add(new Node(1,8));
		
		adj.get(1).add(new Node(4,5));
		adj.get(4).add(new Node(1,5));
		
		adj.get(2).add(new Node(4,7));
		adj.get(4).add(new Node(2,7));
		
		PrimsAlgo obj = new PrimsAlgo();
		obj.MST(adj,V);
		System.out.println();
		System.out.println("Efficient One");
		System.out.println();
		obj.EfficientMST(adj,V);
	}

}
