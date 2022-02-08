package internship.graph;

import java.util.*;

public class BFS {
	
	public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[V];
        queue.add(0);
        visited[0] = true;
        
        while(!queue.isEmpty()){
            int temp = queue.poll();
            arr.add(temp);
            for(int val : adj.get(temp)){
                if(!visited[val]){
                    visited[val] = true;
                    queue.add(val);
                }
            }
        }
        
        return arr;
    }
	
}
