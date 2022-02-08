package internship.stackQueue;

import java.util.Scanner;

import java.util.*;
import java.util.Queue;

public class DistanceBinaryMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int grid[][] = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		int res[][] = nearest(grid);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
		
		sc.close();

	}
	
	static class Pair{
        int i,j;
        Pair(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
    
    static int[][] nearest(int[][] grid)
    {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length,m = grid[0].length;
        
        int res[][] = new int[n][m];
        int visited[][] = new int[n][m];
        
        for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(grid[i][j] == 0){
                    res[i][j] = 1;
               }else{
                   visited[i][j] = 1;
                   q.add(new Pair(i,j));
               }
           } 
        }
        
        int x[] = {-1,1,0,0};
        int y[] = {0,0,-1,1};
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Pair curr = q.poll();
                int i = curr.i;
                int j = curr.j;
                
                for(int k=0;k<4;k++){
                    int row = i + x[k];
                    int col = j + y[k];
                    if(row >=0 && row < n && col >= 0 && col < m && visited[row][col] == 0){
                            visited[row][col] = 1;
                            res[row][col] += res[i][j];
                            q.add(new Pair(row,col));
                    }
                }
            }
        }
        
        return res;
    }

}
