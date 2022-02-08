package internship.stackQueue;

import java.util.*;
import java.util.Queue;

public class RottenOranges {

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
		
		System.out.println(orangesRotting(grid));
		
		sc.close();
	}
	
//	TC: O(4*M*N), SC: O(M*N)
	static class Pair{
        int i,j;
        Pair(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
	
    static int orangesRotting(int[][] grid)
    {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length,m = grid[0].length;
        int fresh = 0,ans = -1;
        
        for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(grid[i][j] == 2)
                    q.add(new Pair(i,j));
               else if(grid[i][j] == 1)
                    fresh++;
           } 
        }
        
        if(fresh == 0) return 0;
        
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
                    if(row >=0 && row < n && col >= 0 && col < m && grid[row][col] == 1){
                            fresh--;
                            grid[row][col] = 2;
                            q.add(new Pair(row,col));
                    }
                }
            }
            ans++;
        }
        
        if(fresh != 0) return -1;
        
        return ans;
    }

}
