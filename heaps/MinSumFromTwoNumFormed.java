package internship.heaps;

import java.util.*;

public class MinSumFromTwoNumFormed {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(solve(arr,n));
		
		sc.close();

	}
	
	static String solve(int[] arr, int n) {
		
	       Arrays.sort(arr);
	       StringBuilder res = new StringBuilder();
	       int carry = 0;
	       
	       for(int i=n-1;i>=0;i-=2){
	    	   
	           int num1 = arr[i],num2 = 0;
	           
	           if(i-1 >= 0)  num2 = arr[i-1];
	           
	           if(num1 == 0 && num2 == 0) break;
	           
	           int sum = num1+num2+carry;
	           carry = sum/10;
	           res.append(sum%10);
	       }
	       
	        if(carry > 0)
	            res.append(carry);
	       
	       res.reverse();
	       
	       return res.toString();
	    }

}
