package internship.backTracking;

import java.util.*;

public class PossiblePaths {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		int arr[][] = new int[m][n];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		ArrayList<ArrayList<Integer>> result = findSol(arr,m,n);
		
		for(ArrayList<Integer> ans : result) {
			for(int val : ans) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
	
	static void findPaths(int arr[][],int m,int n,int i,int j,Stack<Integer> list,ArrayList<ArrayList<Integer>> paths){
		if(i> m || j > n)
			return ;
		if(i == m && j == n) {
			paths.add(new ArrayList<Integer>(list));
			return ;
		}
		
		list.push(arr[i][j]);
		findPaths(arr,m,n,i+1,j,list,paths);
		findPaths(arr,m,n,i,j+1,list,paths);
		list.pop();
	}
	
	static ArrayList<ArrayList<Integer>> findSol(int arr[][],int m,int n){
		ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
		findPaths(arr,m-1,n-1,0,0,new Stack<Integer>(),paths);
		return paths;
	}

}
