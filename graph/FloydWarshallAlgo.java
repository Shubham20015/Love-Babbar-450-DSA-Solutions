package internship.graph;

import java.util.Scanner;

// we can also do this all pair shortest path by running bellman ford 'V' times
// TC: O((V^3)logV) , SC: O(V)

// Floyd Warshall works for negative edge but "no negative cycle", whereas Dijkstra’s algorithm don’t work for negative edges

/* Dijkstra’s Algorithm is one example of a single-source shortest path algorithm, i.e., 
 * given a source vertex it finds shortest path from source to all other vertices.
 
 * Floyd Warshall Algorithm is an example of all-pairs shortest path algorithm, 
 * meaning it computes the shortest path between all pair of nodes.
 */

public class FloydWarshallAlgo {
	
//	TC: O(V^3) , SC: O(1)
	static void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;
        for(int k=0;k<n;k++){
           for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][k] == -1 || matrix[k][j] == -1) continue;
                    else if(matrix[i][j] == -1) matrix[i][j] = matrix[i][k]+matrix[k][j];
                    else matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
           } 
        }
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int matrix[][] = new int[V][V];
		
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		shortest_distance(matrix);
		
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
