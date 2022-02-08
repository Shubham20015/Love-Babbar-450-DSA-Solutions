package internship.string;

import java.util.*;

public class RotationChecker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.next();
		String str2 = sc.next();
		
		boolean result = str1.length() == str2.length() && (str1 + str1).contains(str2);
		
		System.out.println(result);
		
		sc.close();
	}

}
