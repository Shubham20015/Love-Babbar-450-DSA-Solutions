package internship.matrix;

import java.util.*;

public class SpiralMatrix {

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
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		int top = 0,down = r-1;
		int left = 0,right = c-1;
		int count = 0,total = r*c;
		
		while(count < total) {
			for(int i=left;i<=right;i++) {
				if(count >= total) {
					break;
				}
				arr.add(matrix[top][i]);
				count++;
			}
			top++;
			for(int i=top;i<=down;i++) {
				if(count >= total) {
					break;
				}
				arr.add(matrix[i][right]);
				count++;
			}
			right--;
			for(int i=right;i>=left;i--) {
				if(count >= total) {
					break;
				}
				arr.add(matrix[down][i]);
				count++;
			}
			if(count >= total) {
				break;
			}
			down--;
			for(int i=down;i>=top;i--) {
				if(count >= total) {
					break;
				}
				arr.add(matrix[i][left]);
				count++;
			}
			left++;
		}
		
		for(int val : arr) {
			System.out.print(val + " ");
		}
		
		sc.close();
	}

}
