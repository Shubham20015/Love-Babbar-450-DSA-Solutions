package internship.graph;

import java.util.*;

public class OliverAndBobGame {
	
	static int timer;
	
	public static void dfs(int src,int parent,List<ArrayList<Integer>> adj,int inTime[],int outTime[]) {
		inTime[src] = timer++;
		for(int node : adj.get(src)) {
			if(node != parent) {
				dfs(node,src,adj,inTime,outTime);
			}
		}
		outTime[src] = timer++;
	}
	
	public static boolean check(int x,int y,int inTime[],int outTime[]) {
		return inTime[x] > inTime[y] && outTime[x] < outTime[y];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<ArrayList<Integer>> adj = new ArrayList<>();
		timer = 1;
		
		int n = sc.nextInt();
		int inTime[] = new int[n+1];
		int outTime[] = new int[n+1];
		
		for(int i=0;i<=n;i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i=0;i<n-1;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		
		dfs(1,0,adj,inTime,outTime);
		
		int q = sc.nextInt();
		
		while(q-->0) {
			int type = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(type == 0) {
				System.out.println(check(y,x,inTime,outTime) ? "YES" : "NO");
			}else {
				System.out.println(check(x,y,inTime,outTime) ? "YES" : "NO");
			}
		}
		
		sc.close();
	}

}
