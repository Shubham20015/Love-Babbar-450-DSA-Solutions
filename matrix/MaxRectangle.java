package internship.matrix;

import java.util.*;

public class MaxRectangle {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int matrix[][] = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		int curRow[] = matrix[0];
		int maxAns = maxArea(curRow);
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<m;j++) {
				
				if(matrix[i][j] == 1) {
					curRow[j] += matrix[i][j];
				}else {
					curRow[j] = 0;
				}
			}
			
			int curAns = maxArea(curRow);
			maxAns = Math.max(maxAns, curAns);
		}
		
		System.out.println(maxAns);
		
		sc.close();
	}
	
	public static int maxArea(int arr[]) {
		int prev[] = prevSmaller(arr);
		int next[] = nextSmaller(arr);
		int res = 0;
		
		for(int i=0;i<arr.length;i++) {
			res = Math.max(res, (next[i]-prev[i]-1)*arr[i]);
		}
		
		return res;
	}
	
	public static int[] prevSmaller(int arr[]) {
		int n = arr.length;
		int prev[] = new int[n];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<n;i++) {
			while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				prev[i] = -1; 
			}else {
				prev[i] = stack.peek();
			}
			stack.push(i);
		}
		
		return prev;
	}
	
	public static int[] nextSmaller(int arr[]) {
		int n = arr.length;
		int next[] = new int[n];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=n-1;i>=0;i--) {
			while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				next[i] = n; 
			}else {
				next[i] = stack.peek();
			}
			stack.push(i);
		}
		
		return next;
	}
}
