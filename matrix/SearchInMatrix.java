package internship.matrix;

import java.util.Scanner;

public class SearchInMatrix {
//	These properties must be remember while entering matrix values
//  Integers in each row are sorted from left to right.
//	The first integer of each row is greater than the last integer of the previous row.
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int rows = sc.nextInt();
		int columns = sc.nextInt();
		int matrix[][] = new int[rows][columns];
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		int target = sc.nextInt();
		
		int targetRow = 0;
		
		for(int i=0;i<rows;i++) {
			if(target > matrix[i][0]) {
				targetRow = i;
			}
		}
		
		for(int i=0;i<columns;i++) {
			if(target == matrix[targetRow][i]) {
				System.out.println(true);
				System.exit(0);
			}
		}
		
		System.out.println(false);
		
		sc.close();
	}

}
