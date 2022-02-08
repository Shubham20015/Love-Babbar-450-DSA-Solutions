package internship.searchingSorting;

import java.util.Scanner;

public class ProductArrayPuzzle {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		long left[] = new long[n];
	    long right[] = new long[n];
	    long ans[] = new long[n];
	    
	    left[0] = 1;
        for(int i=1;i<n;i++){
            left[i] = arr[i-1]*left[i-1];
        }
        
        right[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            right[i] = arr[i+1]*right[i+1];
        }
        
        for(int i=0;i<n;i++){
            ans[i] = left[i]*right[i];
        }
        
        for(long val : ans) {
        	System.out.print(val + " ");
        }
		
		sc.close();

	}

}
