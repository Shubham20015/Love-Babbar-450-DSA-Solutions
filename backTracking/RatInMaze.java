package internship.backTracking;

import java.util.*;

public class RatInMaze {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m[][] = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				m[i][j] = sc.nextInt();
			}
		}
		
		ArrayList<String> res = findPath(m,n);
		
		if(res.isEmpty()) {
			System.out.println(-1);
		}else {
			for(String str : res) {
				System.out.println(str + " ");
			}
		}
		
		sc.close();
	}
	
	public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        if(m[0][0] == 0 || m[n-1][n-1] == 0)
            return ans;
        int visited[][] = new int[n][n];
        ratMaze(m,0,0,n,visited,ans,"");
        Collections.sort(ans);
        return ans;
    }
    
    static void ratMaze(int arr[][],int i,int j,int n,int visited[][],ArrayList<String> ans,String result){
        if(i < 0 || j < 0 || j > n-1 || i > n-1 || arr[i][j] == 0 || visited[i][j] == 1)
            return ;
    
        if(i == n-1 && j == n-1){
            ans.add(result);
            return ;
        }
        
        visited[i][j] = 1;
        ratMaze(arr,i+1,j,n,visited,ans,result+'D');
        ratMaze(arr,i-1,j,n,visited,ans,result+'U');
        ratMaze(arr,i,j+1,n,visited,ans,result+'R');
        ratMaze(arr,i,j-1,n,visited,ans,result+'L');
        visited[i][j] = 0;
    }

}
