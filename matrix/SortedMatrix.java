package internship.matrix;

import java.util.*;

public class SortedMatrix {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int matrix[][] = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;i<N;j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		int arr[] = new int[N*N];
        int size = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arr[size++] = matrix[i][j];
            }
        }
        Arrays.sort(arr);
        size = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                matrix[i][j] = arr[size++];
            }
        }
        
        for(int i=0;i<N;i++) {
			for(int j=0;i<N;j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}

}
