package internship.string;

import java.util.Scanner;

public class SplitBinary {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int count0 = 0,count1 = 0,max = 0;
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch == '0') {
				count0++;
			}else {
				count1++;
			}
			if(count0 == count1) {
				max++;
			}
		}

		System.out.println(max != 0?max:-1);
		
		sc.close();
	}

}
