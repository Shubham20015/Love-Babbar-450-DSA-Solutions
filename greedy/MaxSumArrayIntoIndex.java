package internship.greedy;

import java.util.*;

public class MaxSumArrayIntoIndex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(Maximize(arr, n));
		
		sc.close();
	}
	
	static int Maximize(int arr[], int n)
    {
        Arrays.sort(arr);
        long sum = 0;
        long mod = (long)1e9+7;
        for(int i=0;i<n;i++){
            sum = (sum + (long)arr[i]*i)%mod;
        }
        
        return (int) sum;
    }   

}
