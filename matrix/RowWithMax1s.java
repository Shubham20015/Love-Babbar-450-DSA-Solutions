package internship.matrix;

import java.util.*;

public class RowWithMax1s {
	
//	Remember while entering values in matrix
//	- Enter only 0/1 values
//	- Enter in sorted manner (rows are sorted)
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		int matrix[][] = new int[rows][cols];
		
		for(int i=0;i<rows;i++) {
			for(int j=0;i<cols;j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		int i = 0, j = cols-1, result = -1;
        while(i<rows && j>=0){
            if(matrix[i][j] == 1){
                result = i;
                j--;
            }else{
                i++;
            }
        }
        
        System.out.println(result);
		
		sc.close();
	}

}
