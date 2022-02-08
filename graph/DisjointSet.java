package internship.graph;

import java.util.*;

// TC: O(4 alpha) ~= O(4) or O(constant) , SC: O(N)
public class DisjointSet {
	final int MAX = 100000;
	int parent[] = new int[MAX];
	int rank[] = new int[MAX];
	
	DisjointSet(int n) {
		for(int i=0;i<n;i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}
	
	int findParent(int node) {
		if(node == parent[node]) {
			return node;
		}
		
		return parent[node] = findParent(parent[node]); // path compression
	}
	
	void union(int u,int v) {
		if(rank[u] < rank[v]) {
			parent[u] = v;
		}
		else if(rank[v] < rank[u]) {
			parent[v] = u;
		}else {
			parent[u] = v;
			rank[v]++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		DisjointSet ds = new DisjointSet(n);
		
		int m = sc.nextInt();
		while(m-->0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			ds.union(u,v);
		}
		
		if(ds.findParent(2) != ds.findParent(3)) {
			System.out.println("Different Component");
		}else {
			System.out.println("Same Component");
		}
		
		sc.close();
	}

}
