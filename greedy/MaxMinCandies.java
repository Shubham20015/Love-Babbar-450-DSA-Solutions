package internship.greedy;

import java.util.*;

public class MaxMinCandies {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		ArrayList<Integer> ans = candyStore(arr,n,k);
		for(int val : ans)
			System.out.print(val + " ");
		
		sc.close();

	}
	
	static ArrayList<Integer> candyStore(int candies[],int N,int K){
        Arrays.sort(candies);
        int maxCandies = 0,minCandies = 0;
        int i = 0,j = N-1;
        while(i<N && N>0){
            minCandies += candies[i++];
            N -= K;
        }
        
        i = 0;
        
        while(j >= i){
            maxCandies += candies[j--];
            i += K;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(minCandies);
        res.add(maxCandies);
        
        return res;
    }

}
