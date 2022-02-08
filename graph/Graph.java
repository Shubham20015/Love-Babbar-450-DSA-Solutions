package internship.graph;

import java.util.*;

// TC: O(V^2) , SC: O(V^2)
public class Graph {
	
	static List<ArrayList<Integer>> adjList = new ArrayList<>();
	static int graphMatrix[][];
	
	public void addMatEdge(int u,int v) {
		graphMatrix[u][v] = 1;
		graphMatrix[v][u] = 1;
	}
	
	public void removeMatEdge(int u,int v) {
		graphMatrix[u][v] = 0;
		graphMatrix[v][u] = 0;
	}
	
	public void addEdge(int u,int v) {
		adjList.get(u).add(v);
		adjList.get(v).add(u);
	}
	
	public void printGraph() {
		int i = 0;
		for(ArrayList<Integer> temp : adjList) {
			System.out.print(i++ + " -> ");
			for(int val : temp) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
	
	public void printMatGraph() {
		int n = graphMatrix.length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(graphMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Graph graph = new Graph();
		int V = sc.nextInt();
		graphMatrix = new int [V][V];
		
		for(int i=0;i<V;i++) {
			adjList.add(new ArrayList<>());
		}
		
		graph.addEdge(2, 3);
		graph.addEdge(2, 0);
		graph.addEdge(3, 4);
		graph.addEdge(0, 4);
		graph.printGraph();
		
		graph.addMatEdge(2, 3);
		graph.addMatEdge(2, 0);
		graph.addMatEdge(3, 4);
		graph.addMatEdge(0, 4);
		graph.printMatGraph();
		
		sc.close();
	}

}
