package internship.graph;

import java.util.*;

public class MinStepsForReachingTargetUsingKnight {
	
	 class Coordinates{
	        int x,y,dist;
	        Coordinates(int x,int y,int dist){
	            this.x = x;
	            this.y = y;
	            this.dist = dist;
	        }
	    }
	    
	 
	    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
	    {
	        boolean visited[][] = new boolean[N+1][N+1];
	        int x[] = {-1,1,-2,2,-2,2,-1,1};
	        int y[] = {-2,-2,-1,-1,1,1,2,2};
	        Queue<Coordinates> q = new LinkedList<>();
	        q.add(new Coordinates(KnightPos[0],KnightPos[1],0));
	        while(!q.isEmpty()){
	            
	            Coordinates curr = q.poll();
	            
	            if(curr.x == TargetPos[0] && curr.y == TargetPos[1]){
	                return curr.dist;
	            }
	            
	            for(int i=0;i<8;i++){
	                int newX = curr.x + x[i];
	                int newY = curr.y + y[i];
	                if(newX >= 1 && newY >= 1 && newX <= N && newY <= N && !visited[newX][newY]){
	                    visited[newX][newY] = true;
	                    q.add(new Coordinates(newX,newY,curr.dist+1));
	                }
	            }
	        }
	        return Integer.MAX_VALUE;
	    }
}
