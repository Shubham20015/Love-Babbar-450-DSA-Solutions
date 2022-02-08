package internship.backTracking;

import java.util.Scanner;

public class PartitionEqualSumSubset {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(equalPartition(n, arr) == 1 ? "Yes":"No");
		
		sc.close();
	}
	
	static int equalPartition(int N, int arr[])
    {
        if(N == 1)
            return 0;
        if(N == 2){
            return arr[0] == arr[1] ? 1:0;
        }
        
        int sum = 0;
        for(int i=0;i<N;i++)
            sum += arr[i];
            
        if(sum%2 == 1)
            return 0;
            
        return rec(sum/2,N-1,arr) ? 1:0;
//        return subsetSum(arr,sum/2,N) ? 1:0;
    }
//    TC: O(N*sum of elements) , SC: O(N*sum of elements || 1)
    static boolean rec(int sum,int N,int arr[]){
        if(sum == 0) return true;
        
        if(N == 0 && sum != 0) return false;
        
        return rec(sum - arr[N],N-1,arr) || rec(sum,N-1,arr);
    }
//  TC: O(N*sum of elements) , SC: O(N*sum of elements)
    static boolean subsetSum(int arr[],int sum,int N){
        boolean subset[][] = new boolean[sum + 1][N + 1];
 
        for (int i = 0; i <= N; i++)
            subset[0][i] = true;
 
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;
        
        for(int i=1;i<=sum;i++){
            for(int j=1;j<=N;j++){
                subset[i][j] = subset[i][j-1];
                if(i >= arr[j-1]){
                    subset[i][j] = subset[i][j-1] || subset[i - arr[j - 1]][j - 1];
                }
            }
        }
        return subset[sum][N];
    }

}
