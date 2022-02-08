package internship.string;

import java.util.Scanner;

public class CountAndSay {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String str = "1";
		
		for(int i=1;i<n;i++) {
			str = countSay(str);
		}
		
		System.out.println(str);
		
		sc.close();
	}
	
	public static String countSay(String str) {
		
		StringBuilder sb = new StringBuilder();
		
		char ch = str.charAt(0);
		int count = 1;
		
		for(int i=1;i<str.length();i++) {
			if(str.charAt(i) == ch) {
				count++;
			}else {
				sb.append(count);
				sb.append(ch);
				ch = str.charAt(i);
				count = 1;
			}
		}
		
		sb.append(count);
        sb.append(ch);
        return sb.toString();
	}

}
