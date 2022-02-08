package internship.greedy;

import java.util.*;

public class MaxSumAfterKnegations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		long arr[] = new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextLong();
		}
		
		System.out.println(maximizeSum(arr,n,k));
		
		sc.close();

	}
	
	static long maximizeSum(long arr[], int n, int k)
    {
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(arr[i] < 0 && k>0){
                arr[i] = -arr[i];
                k--;
            }
            if(k <= 0)
                break;
        }
        
        if(k > 0){
            Arrays.sort(arr);
            while(k-->0)
                arr[0] = -arr[0];
        }
        
        long sum = 0;
        for(long val : arr){
            sum += val;
        }
        
        return sum;
    }

}
