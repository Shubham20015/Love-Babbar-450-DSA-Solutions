package internship.graph;

import java.util.*;

public class MinTimeTakenByEachJob {
	
	public static void addEdge(int u,int v,List<ArrayList<Integer>> adjList) {
		adjList.get(u).add(v);
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		List<ArrayList<Integer>> adjList = new ArrayList<>();
		int V = sc.nextInt();
		
		for(int i=0;i<V;i++) {
			adjList.add(new ArrayList<>());
		}
		
		addEdge(0, 2,adjList);
	    addEdge(0, 3,adjList);
	    addEdge(0, 4,adjList);
	    addEdge(1, 2,adjList);
	    addEdge(1, 7,adjList);
	    addEdge(1, 8,adjList);
	    addEdge(2, 5,adjList);
	    addEdge(3, 5,adjList);
	    addEdge(3, 7,adjList);
	    addEdge(4, 7,adjList);
	    addEdge(5, 6,adjList);
	    addEdge(6, 7,adjList);
	    addEdge(7, 9,adjList);
		
		int jobTime[] = minTime(V,adjList);
		
		for(int val : jobTime) {
			System.out.print(val + " ");
		}
		
		sc.close();
	}
	
	public static int[] minTime(int V,List<ArrayList<Integer>> adjList) {
		int job[] = new int[V];
		int indegree[] = new int[V];
		
		for(int i=0;i<V;i++) {
			for(int temp : adjList.get(i)) {
				indegree[temp]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0;i<V;i++) {
			if(indegree[i] == 0) {
				job[i] = 1;
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(int val : adjList.get(curr)) {
				if(--indegree[val] == 0) {
					job[val] = job[curr] + 1;
					queue.add(val);
				}
			}
		}
		
		return job;
	}
}
