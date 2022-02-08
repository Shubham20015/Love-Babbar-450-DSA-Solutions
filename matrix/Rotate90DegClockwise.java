package internship.matrix;

import java.util.*;

public class Rotate90DegClockwise {
//	If you able to understand this nested for loop, then use this for rotation
	
//	for (int i = 0; i < N / 2; i++)
//    {
//        for (int j = i; j < N - i - 1; j++)
//        {
// 
//            int temp = a[i][j];
//            a[i][j] = a[N - 1 - j][i];
//            a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
//            a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
//            a[j][N - 1 - i] = temp;
//        }
//    }

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int matrix[][] = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<N;j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[N-i-1][j];
				matrix[N-i-1][j] = temp;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i != j && i<j) { // leave only diagonal elements and to ignore two times swapping we use i<j
					int temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
		sc.close();
	}

}
