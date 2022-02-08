package internship;

import java.util.*;

public class TripletSumInArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
				arr[i] =sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		boolean flag = false;
		
		for(int i=1;i<n-1;i++) {
			int j = 0;
			int k = n-1;
			while(j<i && k>i) {
				int res = arr[i] + arr[j] + arr[k];
				if(sum < res) 
					k--;
				else if(sum > res) 
					j++;
				else { 
					flag = true;
					break;
				}
			}
		}
		
		System.out.println(flag);
		
		sc.close();

	}

}
