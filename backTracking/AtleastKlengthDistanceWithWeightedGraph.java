package internship.backTracking;

import java.util.*;

public class AtleastKlengthDistanceWithWeightedGraph {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		int src = sc.nextInt();
		int k = sc.nextInt();
		
		Graph g = new Graph(V);
		
		for(int i=0;i<E;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			g.addEdge(u, v, w);
		}
		
		if(g.pathMoreThanK(src, k))
		      System.out.println("YES");
		else
		      System.out.println("NO");
		
		sc.close();
	}
	
	static class ListNode{
		int vertex;
		int weight;
		ListNode(int vertex,int weight){
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	static class Graph{
		int V;
		ArrayList<ArrayList<ListNode>> adj;
		
		Graph(int V){
			this.V = V;
			adj = new ArrayList<>(V);
			
			for(int i = 0; i < V; i++)
		      {
		        adj.add(new ArrayList<ListNode>());
		      }
		}
		
		void addEdge(int u,int v,int weight) {
			ListNode node1 = new ListNode(v,weight);
			adj.get(u).add(node1);
			ListNode node2 = new ListNode(u,weight);
			adj.get(v).add(node2);
		}
		
		boolean pathMoreThanK(int src,int k) {
			boolean path[] = new boolean[V];
			Arrays.fill(path, false);
			path[src] = true;
			return Kpath(src,k,path);
		}
		
		boolean Kpath(int src,int k,boolean path[]) {
			if(k <= 0)
				return true;
			
			ArrayList<ListNode> iterator = adj.get(src);
			int size = iterator.size();
			for(int i=0;i<size;i++) {
				ListNode temp = iterator.get(i);
				
				int v = temp.vertex;
				int w = temp.weight;
				
				if(path[v])
					continue;
				
				if(w >= k)
					return true;
				
				path[v] = true;
				if(Kpath(v,k-w,path)) return true;
				path[v] = false;
			}
			
			return false;
		}
	}

}
