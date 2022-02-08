package internship.graph;

import java.util.*;

public class DFS {
	public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> arr = new ArrayList<>();
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                arr.add(i);
                dfs(V,adj,visited,i,arr);
            }
        }
        
        return arr;
    }
    
    public void dfs(int V, ArrayList<ArrayList<Integer>> adj,boolean visited[],int i,ArrayList<Integer> arr){
        visited[i] = true;
        for(int val : adj.get(i)){
            if(!visited[val]){
                arr.add(val);
                dfs(V,adj,visited,val,arr);
            }
        }
    }
}
