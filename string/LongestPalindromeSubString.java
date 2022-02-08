package internship.string;

import java.util.Scanner;

public class LongestPalindromeSubString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		char arr[] = str.toCharArray();
		
		int maxLength = 1;
		int low = 0,high = 0,start = 0;
		int len = arr.length;
		for(int i=1;i<len;i++) {
			
			low = i-1;
			high = i;
			
			while(low>=0 && high<len && arr[low] == arr[high]) {
				low--;
				high++;
			}
			
			low++;
			high--;
			
			if(arr[low] == arr[high] && high-low+1 > maxLength) {
				start = low;
				maxLength = high-low+1;
			}
			
			low = i-1;
			high = i+1;
			
			while(low>=0 && high<len && arr[low] == arr[high]) {
				low--;
				high++;
			}
			
			low++;
			high--;
			
			if(arr[low] == arr[high] && high-low+1 > maxLength) {
				start = low;
				maxLength = high-low+1;
			}
		}
		
		String ans = "";
		
		while(maxLength-->0) {
			ans += arr[start];
            start++;
		}
		
		System.out.println(ans);
		
		sc.close();
	}

}
