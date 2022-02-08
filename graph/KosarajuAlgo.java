package internship.graph;

import java.util.*;

public class KosarajuAlgo {
	
//	TC: O(V + E) , SC: O(V)
	public int kosaraju(int V, List<ArrayList<Integer>> adj)
    {
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
//      Generate topological sorted which contains in stack
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,visited,adj,stack);
            }
        }
        
//      Transpose a graph means every direction of edge is reversed
        ArrayList<ArrayList<Integer>> newAdj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            newAdj.add(new ArrayList<>());
        }
        
        for(int u=0;u<V;u++){
            visited[u] = false;
            for(int v : adj.get(u)){
                newAdj.get(v).add(u);
            }
        }
        
        int count = 0;
        
//      Now do dfs for poped element in topological sorted stack and print connected nodes together then print in another line
        while(!stack.isEmpty()){
            int newNode = stack.pop();
            if(!visited[newNode]){
                revDfs(newNode,visited,newAdj);
                System.out.println();
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(int node,boolean visited[],List<ArrayList<Integer>> adj,
    Stack<Integer> stack){
        visited[node] = true;
        for(int it : adj.get(node)){
            if(!visited[it]){
                dfs(it,visited,adj,stack);
            }
        }
        stack.push(node);
    } 
    
    private void revDfs(int node,boolean visited[],List<ArrayList<Integer>> newAdj){
        visited[node] = true;
         System.out.print(node + " ");
        for(int it : newAdj.get(node)){
            if(!visited[it]){
                revDfs(it,visited,newAdj);
            }
        }
    } 

	public static void main(String[] args) {
		int V = 5;
		List<ArrayList<Integer>> adj = new ArrayList<>();
		
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<>());
		}
		
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(2).add(0);
		adj.get(1).add(3);
		adj.get(3).add(4);
		
		KosarajuAlgo obj = new KosarajuAlgo();
		System.out.println("Strongly connected components: " + obj.kosaraju(V, adj));
	}

}
