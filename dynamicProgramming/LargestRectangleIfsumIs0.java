package internship.dynamicProgramming;

import java.util.*;

// The naive solution for this problem is to check every possible rectangle in given 2D array.
// This naive solution requires 4 nested loops and time complexity of this solution would be O(n^4).

public class LargestRectangleIfsumIs0 {
	
	static int[] sumZero(int arr[],int n) {
		HashMap<Integer,Integer> map = new HashMap<>();
		
		int sum = 0,maxLen = 0,ending_index = 0;
		
		for(int i=0;i<n;i++) {
			sum += arr[i];
			
			if(arr[i] == 0) {
				maxLen = Math.max(maxLen, 1);
			}
			
			if(sum == 0) {
				maxLen = Math.max(maxLen, i+1);
				ending_index = i;
			}
			
			if(map.containsKey(sum)) {
				int currLen = i - map.get(sum); 
				if(maxLen < currLen) {
					maxLen = currLen;
					ending_index = i;
				}
			}else {
				map.put(sum,i);
			}
		}
		
		return new int[] {maxLen,ending_index};
	}
	
//	TC: O(Cols*Cols*Rows) ~= O(N^3) , SC: O(Rows*MapOfStoringSums) ~= O(N)
	static void sumMatrixWith0(int rows,int cols,int mat[][]) {
		
		int maxArea = 0;
		int maxTop = 0,maxBottom = 0;
		int maxLeft = 0,maxRight = 0;
		
		
		for(int L=0;L<cols;L++) {
			int temp[] = new int[rows];
			for(int R=L;R<cols;R++) {
				
				for(int i=0;i<rows;i++)
					temp[i] += mat[i][R];
				int pair[] = sumZero(temp,rows);
				int area = (R-L+1)*pair[0];
				
				if(maxArea < area) {
					maxArea = area;
					maxLeft = L;
					maxRight = R+1;
					maxTop = (pair[1] - pair[0])+1;
					maxBottom = pair[1]+1;
				}
				
			}
		}
		
		for(int i=maxTop;i<maxBottom;i++) {
			for(int j=maxLeft;j<maxRight;j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
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
		
		sumMatrixWith0(rows,cols,mat);
		
		sc.close();

	}
	
//	Example to test above code
//	4 4
//	9 7 16 5
//	1 -6 -7 3
//	1 8 7 9
//	7 -2 0 10

}
