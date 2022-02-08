package internship.backTracking;

import java.util.*;

public class McoloringProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		 int noOfVertices = sc.nextInt();
         int noOfColors = sc.nextInt();
         int noOfEdges = sc.nextInt();

         @SuppressWarnings("unchecked")
		List<Integer>[] graph = new ArrayList [noOfVertices];
         
         for (int i = 0; i < noOfVertices; i++) {
             graph[i] = new ArrayList<>();
         }

         for (int i = 0; i < noOfEdges; i++) {
             int u = sc.nextInt() - 1;
             int v = sc.nextInt() - 1;
             graph[u].add(v);
             graph[v].add(u);
         }
         
         int[] color = new int[noOfVertices];
         Arrays.fill(color,-1);
         System.out.println(graphColoring(graph, color, noOfVertices, noOfColors,0) ? 1 : 0);
		
		sc.close();
	}
	    
	static boolean graphColoring(List<Integer>[] G, int[] color, int V, int m,int i){
	        if(i == V)
	            return true;
	        for(int j=0;j<m;j++){
	            if(isSafe(G[i],color,V,j)){
	                color[i] = j;
	                if(graphColoring(G,color,V,m,i+1)) return true;
	                color[i] = -1;
	            }
	        }
	        return false;    
	 }
	    
	    static boolean isSafe(List<Integer> a, int[] color, int V, int j){
	        for(int k=0;k<a.size();k++){
	            if(j == color[a.get(k)])
	                return false;
	        }
	        return true;
	    }

}
