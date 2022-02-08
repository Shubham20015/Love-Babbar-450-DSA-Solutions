package internship.graph;

import java.util.*;

public class KruskalAlgo {
	
	static class Node{
		int u,v,w;
		Node(int _u,int _v,int _w){
			u = _u;
			v = _v;
			w = _w;
		}
		
		int getU() {
			return u;
		}
		
		int getV() {
			return v;
		}
		
		int getWeight() {
			return w;
		}
	}
	
	static int findParent(int node,int parent[]) {
		if(parent[node] == node) {
			return node;
		}
		
		return parent[node] = findParent(parent[node],parent);
	}
	
	static void union(int u,int v,int rank[],int parent[]) {
		if(rank[u] < rank[v]) {
			parent[u] = v;
		}
		else if(rank[v] < rank[u]) {
			parent[v] = u;
		}
		else {
			parent[v] = u;
			rank[u]++;
		}
	}
	
	public void MST(ArrayList<Node> adj,int V) {
		int rank[] = new int[V];
		int parent[] = new int[V];
		
		for(int i=0;i<V;i++) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		Collections.sort(adj,(Node a,Node b) -> a.w - b.w);
		
		int costMST = 0;
		ArrayList<Node> mst = new ArrayList<>();
		
		for(Node node : adj) {
			int currV = node.getV();
			int currU = node.getU();
			int currWeight = node.getWeight();
			if(findParent(currU,parent) != findParent(currV,parent)) {
				costMST += currWeight;
				mst.add(node);
				union(currU,currV,rank,parent);
			}
		}
		
		System.out.println("Total edge cost of MST: " + costMST);
		
		for(Node temp : mst)
			System.out.println(temp.getU() + " -> " + temp.getV());
	}

	public static void main(String[] args) {
		ArrayList<Node> adj = new ArrayList<>();
		int V = 7;
		
		adj.add(new Node(1,4,1));
		adj.add(new Node(1,2,2));
		adj.add(new Node(2,3,3));
		adj.add(new Node(2,4,3));
		adj.add(new Node(1,5,4));
		adj.add(new Node(3,4,5));
		adj.add(new Node(2,6,7));
		adj.add(new Node(3,6,8));
		adj.add(new Node(4,5,9));
		
		KruskalAlgo obj = new KruskalAlgo();
		obj.MST(adj,V);
	}

}
