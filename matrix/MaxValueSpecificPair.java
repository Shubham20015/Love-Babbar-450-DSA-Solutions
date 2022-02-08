package internship.matrix;

import java.util.Scanner;

public class MaxValueSpecificPair {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int mat[][] = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(findMax(mat,n));
		
		sc.close();
	}
	
	static int findMax(int mat[][],int n) {
		int max = Integer.MIN_VALUE;
		
		int maxArr[][] = new int[n][n];
	      
        maxArr[n-1][n-1] = mat[n-1][n-1];
        
        int maxv = mat[n-1][n-1];
        for(int j=n-2;j>=0;j--) {
        	if(mat[n-1][j] > maxv) {
        		maxv = mat[n-1][j];
        	}
        	maxArr[n-1][j] = maxv;
        }
        
        maxv = mat[n-1][n-1];
        for(int i=n-2;i>=0;i--) {
        	if(mat[i][n-1] > maxv) {
        		maxv = mat[i][n-1];
        	}
        	maxArr[i][n-1] = maxv;
        }
        
        for(int i=n-2;i>=0;i--) {
        	for(int j=n-2;j>=0;j--) {
        		if(maxArr[i+1][j+1] - mat[i][j] > max) {
        			max = maxArr[i+1][j+1] - mat[i][j];
        		}
        		
        		maxArr[i][j] = Math.max(mat[i][j],Math.max(maxArr[i][j + 1],maxArr[i + 1][j]));
        	}
        }
        
        for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(maxArr[i][j] + " ");
			}
			System.out.println();
		}
        
        return max;
	}

}
