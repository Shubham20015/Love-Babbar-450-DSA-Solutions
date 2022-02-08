package internship.string;

import java.util.*;

public class NotZigZagSearchIn2d {
//	You have to submit on geeksforgeeks by storing answer

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		char arr[][] = new char[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j] = sc.next().charAt(0);
			}
		}
		
		String word = sc.next();
		
		patternSearch(arr,word);
		
		sc.close();
	}
	
	static void patternSearch(char[][] grid,String word)
	    {
			int n = grid.length;
			int m = grid[0].length;
	        for (int row = 0; row < n; row++) {
	            for (int col = 0; col < m; col++) {
	                if (search2D(grid, row, col, word)) {
	                    System.out.println("Pattern found at " + row + ", " + col);
	                }
	            }
	        }
	    }
	
	static boolean search2D(char[][] grid,int row,int col,String word) {
		
		int x[] = {-1,-1,-1,0,0,1,1,1};
		int y[] = {-1,0,1,-1,1,-1,0,1};
		
		int n = grid.length;
		int m = grid[0].length;
		
		if(grid[row][col] != word.charAt(0)) {
			return false;
		}
		
		int len = word.length();
		
		for(int d=0;d<8;d++) {
			int k,i = row+x[d],j = col+y[d];
			
			for(k=1;k<len;k++) {
				if(i<0 || j<0 || i>=n || j>=m || grid[i][j] != word.charAt(k)) {
					break;
				}
				i += x[d];
				j += y[d];
			}
			
			if(k == len)
				return true;
		}
		
		return false;
	}

}
