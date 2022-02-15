package internship.dynamicProgramming;

import java.util.Scanner;

public class MinJumpsReqd {
	
	static int minJumps(int[] arr){
        int n = arr.length;
        
        if (n <= 1)
            return 0;


        if (arr[0] == 0)
        	return -1;
		
		int jumps = 1,maxReach= arr[0],steps=arr[0];
		
		for(int i=1;i<n;i++) {
			if(i == n-1) {
				return jumps;
			}
			maxReach = Math.max(maxReach, i+arr[i]);
			steps--;
			
			if(steps == 0) {
				jumps++;
				if(i >= maxReach) {
					return -1;
				}
				steps = maxReach - i; 
			}
			
		}
		
		return -1;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Minimum jumps required: " + minJumps(arr));
		
		sc.close();

	}

}
