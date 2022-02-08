package internship.backTracking;

import java.util.Scanner;

public class PartitionsIntoSumOfK {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(isKPartitionPossible(arr,n,k) ? "Yes" : "No");
		
		sc.close();
	}
	
	static boolean flag;
	static boolean isKPartitionPossible(int a[], int n, int k)
    {
	    int sum = 0;
	    for(int val : a){
	        sum += val;
	    }
	    
	    if(sum%k != 0)
	        return false;
	    
	    flag = false;
	    int visited[] = new int[n];
	    solve(a,visited,sum/k,0,0,n,k);
	    return flag;
    }
    
	static void solve(int a[], int visited[],int target,int curr_sum,int pos, int n, int k){
        if(k == 0)
            flag = true;
        if(curr_sum == target)
            solve(a,visited,target,0,0,n,k-1);
        if(pos == n || curr_sum > target){
            return ;
        }    
        if(curr_sum + a[pos] <= target && visited[pos] != 1){
            visited[pos] = 1;
            solve(a,visited,target,curr_sum+a[pos],pos+1,n,k);
            visited[pos] = 0;
        }
        solve(a,visited,target,curr_sum,pos+1,n,k);
    }

}
