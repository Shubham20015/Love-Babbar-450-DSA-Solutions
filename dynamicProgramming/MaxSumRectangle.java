package internship.dynamicProgramming;

import java.util.Scanner;

/* The Naive Solution for this problem is to check every possible rectangle in the given 2D array. 
 * This solution requires 6 nested loops –  
 *	  4 for start and end coordinate of the 2 axis O(N^4) and 2 for the summation of the sub-matrix O(N^2).
 * The overall time complexity of this solution would be O(N^6) */

public class MaxSumRectangle {
	
	static int kadane(int arr[],int n){
        int sum = 0,max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            sum += arr[i];
            
            if(max < sum){
                max = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        
        return max;
    }
    
//	TC: O(Cols*Cols*Rows) ~= O(N^3) , SC: O(Rows) ~= O(N)
    static int maximumSumRectangle(int rows, int cols, int M[][]) {
        
        int max_sum = Integer.MIN_VALUE;
        
        for(int L=0;L<cols;L++){
            int temp[] = new int[rows];
            for(int R=L;R<cols;R++){
                for(int i=0;i<rows;i++)
                    temp[i] += M[i][R];
                
                int curr_sum = kadane(temp,rows);
                max_sum = Math.max(max_sum,curr_sum);
            }
        }
        
        return max_sum;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		int mat[][] = new int[rows][cols];
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Maximum sum of rectangle of matrix: " + maximumSumRectangle(rows, cols, mat));
		
		sc.close();
	}

}
