package internship.graph;

import java.util.*;

public class DetectCycleInUndirectedGraph {   
//	TC: O(V+E) , SC: O(V)
	    public boolean isCycleUsingDFS(int V, ArrayList<ArrayList<Integer>> adj) {
	        boolean visited[] = new boolean[V];
	        for(int i=0;i<V;i++){
	            if(!visited[i]){
	                 if(dfs(adj,visited,i,-1))
	                    return true;
	            }
	        }
	        
	        return false;
	    }
	    
	    public boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean visited[],int i,int parent){
	        visited[i] = true;
	        for(int val : adj.get(i)){
	            if(!visited[val]){
	                if(dfs(adj,visited,val,i)){
	                    return true;
	                }
	            }
	            else if(val != parent){
	                return true;
	            }
	        }
	        
	        return false;
	    }
	    
//		TC: O(V+E) , SC: O(V)
	    public boolean isCycleUsingBFS(int V, ArrayList<ArrayList<Integer>> adj) {
	        boolean visited[] = new boolean[V];
	        for(int i=0;i<V;i++){
	            if(!visited[i]){
	                if(bfs(adj,visited,i,-1))
	                    return true;
	            }
	        }
	        
	        return false;
	    }
	    
	    class Pair{
	        int node;
	        int parent;
	        Pair(int n,int p){
	            node = n;
	            parent = p;
	        }
	    }
	    
	    public boolean bfs(ArrayList<ArrayList<Integer>> adj,boolean visited[],int node,int parent){
	        Queue<Pair> q = new LinkedList<>();
	        q.add(new Pair(node,parent));
	        visited[node] = true;
	        
	        while(!q.isEmpty()){
	            Pair curr = q.poll();
	            node = curr.node;
	            parent = curr.parent;
	            
	            for(int val : adj.get(node)){
	                if(!visited[val]){
	                    visited[val] = true;
	                    q.add(new Pair(val,node));
	                }
	                else if(val != parent){
	                    return true;
	                }
	            }
	        }
	        
	        return false;
	    }
}
