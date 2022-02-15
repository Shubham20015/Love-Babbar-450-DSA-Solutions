package internship.dynamicProgramming;

import java.util.*;

// The naive solution for this problem is to check every possible rectangle in given 2D array by counting the total number of 1’s and 0’s in that rectangle. 
// Naive solution requires 4 nested loops and time complexity of this solution would be O(n^4)

public class LargestAreaWithEqual1s0s {
	static int[] sumZero(int arr[],int n) {
		HashMap<Integer,Integer> map = new HashMap<>();
		
		int maxLen = 0,ending_index = 0,starting_index = 0;
		int sum[] = new int[n];
		
		sum[0] = arr[0]; 
		
		for(int i=1;i<n;i++) {
			sum[i] = sum[i-1] + arr[i];
		}
		
		for(int i=0;i<n;i++) {
			
			if(sum[i] == 0) {
				starting_index = 0;
				ending_index = i;
				maxLen = Math.max(maxLen, i+1);
			}
			
			if(map.containsKey(sum[i])) {
				int currLen = i - map.get(sum[i]); 
				if(maxLen < currLen) {
					maxLen = currLen;
					starting_index = map.get(sum[i]) + 1;
					ending_index = i;
				}
			}else {
				map.put(sum[i],i);
			}
		}
		
		return new int[] {starting_index,ending_index};
	}
	
//	TC: O(Cols*Cols*Rows) ~= O(N^3) , SC: O(Rows*ArrayOfStoringSums) ~= O(N)
	static void LargestArea(int rows,int cols,int mat[][]) {
		
		int maxArea = 0;
		int maxTop = 0,maxBottom = 0;
		int maxLeft = 0,maxRight = 0;
		
		
		for(int L=0;L<cols;L++) {
			int temp[] = new int[rows];
			for(int R=L;R<cols;R++) {
				
				// Calculate sum between current left and right for every row 'i', consider value '1' as '1' and value '0' as '-1'
				for(int i=0;i<rows;i++)
					temp[i] += mat[i][R] == 0 ? -1:1;
				
				int pair[] = sumZero(temp,rows);
				int area = (R-L+1)*(pair[1] - pair[0] + 1);
				
				if(maxArea < area) {
					maxArea = area;
					maxLeft = L;
					maxRight = R;
					maxTop = pair[0];
					maxBottom = pair[1];
				}
				
			}
		}
		
		System.out.println("(Top, Left): " + "(" + maxTop + ", " + maxLeft + ")"); 
		System.out.println("(Bottom, Right): " + "(" + maxBottom + ", " + maxRight + ")"); 
        System.out.println("Area: " + maxArea + " sq.units");     
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
		
		LargestArea(rows,cols,mat);
		
		sc.close();

	}
}
