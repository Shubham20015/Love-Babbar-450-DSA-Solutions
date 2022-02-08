package internship.graph;

import java.util.*;

public class BellmanFordAlgo {
	
	    static void isNegativeWeightCycle(int n, int[][] edges)
	    {
	        int len = edges.length;
	        int dist[] = new int[n];
	        
	        Arrays.fill(dist,Integer.MAX_VALUE);
	        dist[0] = 0;
	        
	        for(int i=0;i<n-1;i++){
	            for(int j=0;j<len;j++){
	                int u = edges[j][0];
	                int v = edges[j][1];
	                int weight = edges[j][2];
	            
	                if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]){
	                    dist[v] = dist[u] + weight;
	                }
	            }
	        }
	        
	        boolean flag = false;
	        
	        for(int j=0;j<len;j++){
	            int u = edges[j][0];
	            int v = edges[j][1];
	            int weight = edges[j][2];
	            
	            if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]){
	                flag = true;
	                break;
	            }
	        }
	        
	        if(!flag) {
	        	for(int i=0;i<n;i++)
	        		System.out.print(dist[i] + " ");
	        }else {
	        	System.out.println("Negative cycle found");
	        }
	    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int edges[][] = new int[m][3];
		
		for(int i=0;i<m;i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}
		
		isNegativeWeightCycle(n, edges);
		
		sc.close();
	}

}
