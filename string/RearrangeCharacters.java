package internship.string;

import java.util.Scanner;

public class RearrangeCharacters {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-->0) {
			String text = sc.next();
			String ans = rearrange(text);
			if(ans == "") {
				System.out.println("0");
			}else {
				System.out.println("1");
			}
		}
		
		
		sc.close();

	}
	
	static String rearrange(String text) {
		int count[] = new int[26];
		int n = text.length();
		
//		maintain frequency of chars
		for(int i=0;i<n;i++) {
			count[text.charAt(i)-'a']++;
		}
		
//		get char of max's count and maxCount
		int max = 0;
		char max_ch = '.';
		for(int i=0;i<26;i++) {
			if(count[i] > max) {
				max = count[i];
				max_ch = (char) ('a' + i);
			}
		}
		
		int maxCount = count[max_ch - 'a'];
//		Check whether result is possible or not
		if(maxCount > (n+1)/2) {
			return "";
		}
		
		char arr[] = new char[n];
		int index = 0;
//		filling even places with maxCount char
		while(maxCount-->0) {
			arr[index] = max_ch; 
			index += 2;		
		}
		count[max_ch - 'a'] = 0;
//		filling remaining even places or odd places or both with remaining characters
		for(int i=0;i<26;i++) {
			while(count[i]-- > 0) {
				index = (index >= n) ? 1 : index;
				arr[index] = (char) ('a' + i);
				index += 2;
			}
		}
		
		return String.valueOf(arr);
	}

}
