package internship.dynamicProgramming;

import java.util.*;

public class GoldMine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int gold[][] = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				gold[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(getGoldMax(gold,n,m));
		
		sc.close();
	}
	
	static int getGoldMax(int gold[][],int n,int m) {
		int goldTable[][] = new int[n][m];
		
		for(int col=m-1;col>=0;col--) {
			for(int row=0;row<n;row++) {
				int right = (col == m-1) ? 0:goldTable[row][col+1];
				int right_up = (row == 0 || col == m-1) ? 0:goldTable[row-1][col+1];
				int right_down = (row == n-1 || col == m-1) ? 0:goldTable[row+1][col+1];
				goldTable[row][col] = gold[row][col] + Math.max(right, Math.max(right_up, right_down));
			}
		}
		
		int res = goldTable[0][0];
		
		for(int i=1;i<n;i++) {
			res = Math.max(res,goldTable[i][0]);
		}
		
		return res;
	}

}
