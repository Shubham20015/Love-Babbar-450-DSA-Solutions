package internship.binaryTree;

import java.util.*;

public class GraphIsTreeOrNot {
	
	static class Graph{
		private int V;
		private LinkedList<Integer> arr[];
		
		@SuppressWarnings("unchecked")
		Graph(int v){
			V = v;
			arr = new LinkedList [V];
			for(int i=0;i<V;i++) {
				arr[i] = new LinkedList<>();
			}
		}
		
		public void addEdge(int v,int w) {
			arr[v].add(w);
			arr[w].add(v);
		}
		
		boolean isTree() {
			
			boolean visited[] = new boolean[V];
			
			Arrays.fill(visited, false);
			
			if(isCyclePresent(visited,0,-1)) {
				return false;
			}
			
			for(int u=0;u<V;u++) {
				if(!visited[u])
					return false;
			}
			
			return true;
		}
		
		boolean isCyclePresent(boolean visited[],int v,int parent) {
			visited[v] = true;
			Integer i;
			
			Iterator<Integer> it = arr[v].iterator();
			while(it.hasNext()) {
				i = it.next();
				
				if(!visited[i]) {
					if(isCyclePresent(visited,i,v)) {
						return true;
					}
				}
				
				else if(i != parent)
					return true;
			}
			
			return false;
		}
	}

	public static void main(String[] args) {
		Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isTree())
            System.out.println("Graph is Tree");
        else
            System.out.println("Graph is not Tree");

	}
	
}
