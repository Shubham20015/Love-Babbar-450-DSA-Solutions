package internship.graph;

import java.util.*;

// TC: O(V+E) , SC: O(2V) ~= O(V)
public class DetectCycleInDirectedGraph {
	
	public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        boolean dfsVisited[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(adj,visited,dfsVisited,i)) return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean visited[],boolean dfsVisited[],int i){
        visited[i] = true;
        dfsVisited[i] = true;
        for(int val : adj.get(i)){
            if(!visited[val]){
                if(dfs(adj,visited,dfsVisited,val)) return true;
            }else if(dfsVisited[val]){
                return true;
            }
        }
        dfsVisited[i] = false;
        return false;
    }
    
//    If not able to make topological sorted array then there must be cycle in directed graph
    public boolean isBFSCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[V];
        for(int i=0;i<V;i++){
            for(int val : adj.get(i)){
                indegree[val]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<V;i++){
            if(indegree[i] == 0)
                q.add(i);
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int val : adj.get(node)){
                indegree[val]--;
                if(indegree[val] == 0)
                    q.add(val);
            }
        }
        
        return count == V ? false:true;
    }
}
