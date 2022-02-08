package internship.graph;

import java.util.*;

public class CheapestFlightsWithKstops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<int[]>> map = new HashMap<>();
        
        for(int flight[]: flights){
            map.computeIfAbsent(flight[0], x -> new ArrayList<int[]>()).add(new int[] {flight[1],flight[2]});
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {src,0});
        
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int count = -1;
        
        while(!q.isEmpty()){
            int size = q.size();
            if(count == k){
                break;
            }
            
            while(size-->0){
                int curr[] = q.poll();
                int node = curr[0];
                int cost = curr[1];
                if(map.containsKey(node)){
                    for(int val[] : map.get(node)){
                        int currNode = val[0];
                        int currCost = val[1];
                        if(cost + currCost < dist[currNode]){
                            dist[currNode] = cost + currCost;
                            q.add(new int[]{currNode,dist[currNode]});
                        }
                    }
                }
            }
            count++;
        }
        
        return dist[dst] != Integer.MAX_VALUE ? dist[dst] : -1;
    }
}
