package internship.matrix;

import java.util.*;

public class CommonElementsInRows {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int matrix[][] = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(int j=0;j<M;j++) {
			map.put(matrix[0][j],1);
		}
		
		for(int i=1;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map.get(matrix[i][j]) != null && map.get(matrix[i][j]) == i) {
					map.put(matrix[i][j], i+1);
				
					if (i == N - 1)
						System.out.print(matrix[i][j] + " ");
				}
			}
		}
		
		sc.close();
	}

}
