package internship.graph;

import java.util.*;

// TC: O(N*N) , SC: O(N*N)
public class SnakeAndLadder {
	public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean visited[][] = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[n-1][0] = true;
        
        int steps = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size-->0){
                int currNo = queue.poll();
                if(currNo == n*n) return steps;
                for(int k=1;k<=6;k++){
                    int newNo = currNo+k;
                    if(newNo > n*n) break;
                    int pos[] = findCordinates(newNo,n);
                    int row = pos[0];
                    int col = pos[1];
                    if(visited[row][col]) continue;
                    visited[row][col] = true;
                    if(board[row][col] == -1){
                        queue.offer(newNo);
                    }else{
                        queue.offer(board[row][col]);
                    }
                }
            }
            
            steps++;
        }
        
        return -1;
    }
    
    int[] findCordinates(int curr,int n){
        int row = n - (curr-1)/n-1;
        int col = (curr-1)%n;
        
        if(row%2 == n%2){
            return new int[] {row,n-col-1};
        }else{
            return new int[] {row,col};
        }
    }
}
