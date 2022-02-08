package internship.graph;

import java.util.*;

public class Mcoloring {
	public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int m) 
    {
        int size = G.length;
        Arrays.fill(color,-1);
        return fillColor(G,color,size,m,0);
    }
    
    private static boolean fillColor(List<Integer>[] G,int[] color,int size,int m,int index){
        if(index == size){
            return true;
        }
        
        for(int j=0;j<m;j++){
            if(isSafe(G[index],color,j)){
                color[index] = j;
                if(fillColor(G,color,size,m,index+1)) return true;
                color[index] = -1;
            }
        }
        
        return false;
    }
    
    private static boolean isSafe(List<Integer> G,int color[],int j){
        int n = G.size();
        for(int i=0;i<n;i++){
            if(color[G.get(i)] == j) return false;
        }
        
        return true;
    }
}
