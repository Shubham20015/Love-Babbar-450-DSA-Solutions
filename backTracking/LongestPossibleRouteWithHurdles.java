package internship.backTracking;

import java.util.*;

public class LongestPossibleRouteWithHurdles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int matrix[][] = new int[r][c];
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		boolean visited[][] = new boolean[r][c];
		
		for(int i=0;i<r;i++) {
			Arrays.fill(visited[i], false);
		}
		
		solve(r,c,matrix,visited,0,0,1,2,0);
		if(ans != Integer.MIN_VALUE) {
			System.out.println("Length of longest possible route is " + ans);
		}else {
			System.out.println("Destination not reachable from given source");
		}
//		1 1 1 1 1 1 1 1 1 1
//      1 1 0 1 1 0 1 1 0 1
//      1 1 1 1 1 1 1 1 1 1
		sc.close();
	}
	
	static int ans = Integer.MIN_VALUE;
	static void solve(int row,int col,int mat[][],boolean visited[][],int startX,int startY,int endX,int endY,int pathlength) {
		if(startX == endX && startY == endY) {
			if(ans < pathlength)
				ans = pathlength;
			return ;
		}
		
		if(startX < 0 || startY < 0 || startX >= row || startY >= col || mat[startX][startY] == 0 || visited[startX][startY])
			return ;
		visited[startX][startY] = true;
		solve(row,col,mat,visited,startX-1,startY,endX,endY,pathlength+1);
		solve(row,col,mat,visited,startX+1,startY,endX,endY,pathlength+1);
		solve(row,col,mat,visited,startX,startY-1,endX,endY,pathlength+1);
		solve(row,col,mat,visited,startX,startY+1,endX,endY,pathlength+1);
		visited[startX][startY] = false;
	}
}
