package internship.dynamicProgramming;

import java.util.*;

public class PairWithLessKdiff {
	
	public static int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K) 
    {
        Arrays.sort(arr);
        int i = N-1,sum = 0;
        while(i>0){
            if(arr[i]-arr[i-1] < K){
                sum += arr[i] + arr[i-1];
                i -= 2;
            }else{
                i--;
            }
        }
        
        return sum;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(maxSumPairWithDifferenceLessThanK(arr,n,k));
		
		sc.close();
	}

}
