package internship.string;

import java.util.Scanner;

public class NumericPadString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		String numericPad[] = {"2","22","222",
							   "3","33","333",
							   "4","44","444",
							   "5","55","555",
							   "6","66","666",
							   "7","77","777","7777",
							   "8","88","888",
							   "9","99","999","9999"};
		
		str = str.toLowerCase();
		int n = str.length();
		String ans = "";
		
		for(int i=0;i<n;i++) {
			char ch = str.charAt(i);
			ans += (ch == ' ' ?"0":numericPad[(ch - 'a')]);
		}
		
		System.out.println(ans);
		
		sc.close();
	}

}
