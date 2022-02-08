package internship.graph;

import java.util.*;

public class AbleToFinishTasksOrNot {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		int arr[][] = new int[E][2];
		
		for(int i=0;i<E;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
	
		System.out.print(canFinish(V, arr));
		
		sc.close();
	}
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<ArrayList<Integer>> adjList = new ArrayList<>();
		int len = prerequisites.length;
        
        int indegree[] = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<numCourses;i++) {
			adjList.add(new ArrayList<>());
		}
        
        for(int i=0;i<len;i++) {
			adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
        
        for(int i=0;i<numCourses;i++) {
			for(int val : adjList.get(i)){
                indegree[val]++;
            }
		}
        
        for(int i=0;i<numCourses;i++) {
			if(indegree[i] == 0){
                  q.add(i);
            }
		}
        
        int count = 0;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            for(int val : adjList.get(curr)){
                if(--indegree[val] == 0){
                    q.add(val);
                }
            }
        }
        
        return count == numCourses;
    }
}
