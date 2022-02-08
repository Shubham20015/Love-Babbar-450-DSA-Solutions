package internship.graph;

import java.util.*;

public class MakeWiredConnections {
	public int makeConnected(int n, int[][] connections) {
        boolean visited[] = new boolean[n];
        List<ArrayList<Integer>> adjList = new ArrayList<>();
        int len = connections.length;
        
//        Check whether sufficient n-1 edges are present to connect n nodes as len is no. of edges given
        if(len < n-1) return -1;
        
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0;i<len;i++){
            adjList.get(connections[i][0]).add(connections[i][1]);
            adjList.get(connections[i][1]).add(connections[i][0]);
        }
        
//        Here we count no of components in graph as we reqd count-1 edges
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,adjList,visited);
            }
        }
        
        return count-1;
        
    }
    
    private void dfs(int x,List<ArrayList<Integer>> adjList,boolean visited[]){
        visited[x] = true;
        for(int val: adjList.get(x)){
            if(!visited[val]){
                dfs(val,adjList,visited);
            }
        }
    }
}
