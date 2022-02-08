package internship.string;

import java.util.Scanner;

public class MakePalindromeAddingFront {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int ans = makePalindromeArray(str);
		System.out.println(ans);
		
		sc.close();

	}
	
	static int makePalindromeArray(String str) {
		StringBuilder s = new StringBuilder();
		s.append(str);
		
		String rev = s.reverse().toString();
		s.reverse().append('$' + rev);
		
		int lps[] = computeLPSArray(s.toString());
		
		return str.length() - lps[s.length() -1];
	}
	
	static int[] computeLPSArray(String str) {
		int n = str.length();
		int lps[] = new int[n];
		int len = 0,i = 1;
		lps[0] = 0;
		
		while(i<n) {
			if(str.charAt(i) == str.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}else {
				if(len != 0) {
					len = lps[len-1];
				}else {
					lps[i] = len;
					i++;
				}
			}
		}
		
		return lps;
	}

}
