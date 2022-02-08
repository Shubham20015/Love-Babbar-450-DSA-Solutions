package internship.string;

import java.util.Scanner;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String str[] = new String[n];
		
		for(int i=0;i<n;i++) {
			str[i] = sc.next();
		}
		
		if(n == 0)
			System.out.println("''");
		
		String prefix = str[0];
		
		for(int i=1;i<n;i++) {
			while(str[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0,prefix.length()-1);
				if (prefix.isEmpty()) {
					System.out.println("''");
					break;
				}
			}
		}
		
		System.out.println(prefix);
		
		sc.close();
	}

}
