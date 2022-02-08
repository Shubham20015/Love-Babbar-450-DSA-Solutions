package internship;

import java.util.*;

public class KthElementInMatrix {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int matrix[][] = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pq.offer(matrix[i][j]);
                
                if(pq.size() > k)
                    pq.poll();
            }
        }
        
        System.out.println(pq.peek());
        
        sc.close();
	}

}
