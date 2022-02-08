package internship;

import java.util.*;

public class TrappingWater {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
				arr[i] =sc.nextInt();
		}
		
		int start = 0;
		int end = n-1;
		
		int leftmax = 0,rightmax = 0;
		long sum = 0;
		while(start<end) {
			leftmax = Math.max(leftmax, arr[start]);
			rightmax = Math.max(rightmax, arr[end]);
			
			if(rightmax < leftmax) {
				sum += rightmax-arr[end--];
			}else {
				sum += leftmax-arr[start++];
			}
		}
		
		System.out.println(sum);
		
		sc.close();

	}

}
