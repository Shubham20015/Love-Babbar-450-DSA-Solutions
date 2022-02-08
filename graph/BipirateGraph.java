package internship.graph;

import java.util.*; 

public class BipirateGraph {
	
	public boolean checkBFSBipirate(int V,List<ArrayList<Integer>> adj) {
		int color[] = new int[V];
		Arrays.fill(color, -1);
		
		for(int i=0;i<V;i++) {
			if(!bfsCheck(i,adj,color))
				return false;
		}
		
		return true;
		
//		return !bfsCheck(0,adj,color) ? false:true;
	}
	
	private boolean bfsCheck(int node,List<ArrayList<Integer>> adj,int color[]) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		color[node] = 1;
		
		while(!q.isEmpty()) {
			node = q.poll();
			for(int it : adj.get(node)) {
				if(color[it] == -1) {
					color[it] = 1 - color[node];
					q.add(it);
				}
				else if(color[it] == color[node]) {
						return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean checkDFSBipirate(int V,List<ArrayList<Integer>> adj) {
		int color[] = new int[V];
		Arrays.fill(color, -1);
		
		for(int i=0;i<V;i++) {
			if(color[i] == -1 && !dfsCheck(i,adj,color))
				return false;
		}
		
		return true;
	}
	
	private boolean dfsCheck(int node,List<ArrayList<Integer>> adj,int color[]) {
		color[node] = 1;
		for(int it : adj.get(node)) {
			if(color[it] == -1) {
				color[it] = 1 - color[node];
				dfsCheck(it,adj,color);
			}
			else if(color[it] == color[node]) {
					return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		int V = 7;
		List<ArrayList<Integer>> adj = new ArrayList<>();
		
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<>());
		}
		
		adj.get(0).add(1);
		adj.get(1).add(0);
		
		adj.get(1).add(2);
		adj.get(2).add(1);
		
		adj.get(2).add(3);
		adj.get(3).add(2);
		
		adj.get(4).add(3);
		adj.get(3).add(4);
		
		adj.get(4).add(5);
		adj.get(5).add(4);
		
		adj.get(4).add(6);
		adj.get(6).add(4);
		
		adj.get(1).add(6);
		adj.get(6).add(1);
		
		BipirateGraph obj = new BipirateGraph();
		boolean ans1 = obj.checkBFSBipirate(V,adj);
		boolean ans2 = obj.checkDFSBipirate(V,adj);
		System.out.println(ans1 + " " + ans2);
	}

}
