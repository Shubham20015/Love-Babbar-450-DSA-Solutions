package internship.graph;

import java.util.Scanner;

public class NoOfTriangles {
	
//	TC: O(V^3) , SC: O(1)
	public static int countTringles(int graph[][],int n,boolean isDirected) {
		int count = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(graph[i][j] == 1 && graph[j][k] == 1 && graph[k][i] == 1)
						count++;
				}
			}
		}
		
		if(isDirected) {
			count /= 3;
		}else {
			count /= 6;
		}
		
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int graph[][] = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Total no of triangles: " + countTringles(graph,n,true));
		
		sc.close();
	}

}
