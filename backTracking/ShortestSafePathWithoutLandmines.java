package internship.backTracking;

import java.util.Arrays;
import java.util.Scanner;

public class ShortestSafePathWithoutLandmines {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int land[][] = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				land[i][j] = sc.nextInt();
			}
		}
		
		boolean ans = findPath(n,m,land);
		
		System.out.println(ans ? "Min distance possible: " + min_dist : "Impossible to reach an end");
		
		sc.close();
	} 
	
	static int min_dist;
	
	static boolean findPath(int n,int m,int land[][]) {
		min_dist = Integer.MAX_VALUE;
		boolean[][] visited = new boolean[n][m];
		markUnsafeCells(n,m,land);
		
		for(int i=0;i<n;i++) {
			if(land[i][0] == 1) {
				for(int x=0;x<n;x++) {
					Arrays.fill(visited[x], false);
				}
				
				findShortestPath(land,visited,i,0,0,n,m);
				
				if(min_dist == m-1)
					break;
			}
		}
		return min_dist != Integer.MAX_VALUE;
	}
	
	static void findShortestPath(int land[][],boolean visited[][],int i,int j,int dist,int n,int m) {
		
		int x[] = {-1,0,1,0};
		int y[] = {0,1,0,-1};
		
		if(j == m-1) {
			min_dist = Math.min(min_dist, dist);
			return ;
		}
		
		if(dist > min_dist)
			return ;
		
		visited[i][j] = true;
		
		for(int k=0;k<4;k++) {
			int new_X = i+x[k],new_Y = j+y[k];
			if(isValid(new_X,new_Y,n,m) && isSafe(land,visited,new_X,new_Y)) {
				findShortestPath(land,visited,new_X,new_Y,dist+1,n,m);
			}
		}
		
		visited[i][j] = false;
	}
	
	static boolean isValid(int x,int y,int n,int m) {
		return (x < n && y < m && x >= 0 && y >= 0);
	}
	
	static boolean isSafe(int land[][],boolean visited[][],int x,int y) {
		return (land[x][y] == 1 && !visited[x][y]);
	}
	
	static void markUnsafeCells(int n,int m,int land[][]) {
		
		int x[] = {-1,0,1,0};
		int y[] = {0,1,0,-1};
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(land[i][j] == 0) {
					for(int k=0;k<4;k++) {
						int new_X = i+x[k],new_Y = j+y[k];
						if(isValid(new_X,new_Y,n,m)) {
							land[new_X][new_Y] = -1;
						}
					}
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(land[i][j] == -1)
					land[i][j] = 0;
			}
		}
		
	}

}
