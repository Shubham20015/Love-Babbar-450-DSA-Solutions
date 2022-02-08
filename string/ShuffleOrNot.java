package internship.string;

import java.util.*;

public class ShuffleOrNot {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.next();
		String str2 = sc.next();
		String result = sc.next();
		
		if(checkLength(str1,str2,result) && shuffleCheck(str1,str2,result)) {
			System.out.println(result + " is valid shuffled");
		}else {
			System.out.println(result + " is not valid shuffled");
		}
		
		sc.close();
	}
	
	public static boolean checkLength(String str1,String str2,String result) {
		return str1.length()+str2.length() == result.length();
	}
	
	public static boolean shuffleCheck(String str1,String str2,String result) {
		
		str1 = sortedString(str1);
		str2 = sortedString(str2);
		result = sortedString(result);
		
		int i=0,j=0,k=0;
		
		while(k<result.length()) {
			if(i<str1.length() && str1.charAt(i) == result.charAt(k))
				i++;
			else if(j<str2.length() && str2.charAt(j) == result.charAt(k))
				j++;
			else
				return false;
			k++;
		}
		
		if(i<str1.length() || j<str2.length())
			return false;
		
		return true;
	}
	
	public static String sortedString(String temp) {
		char arr[] = temp.toCharArray();
		Arrays.sort(arr);
		return String.valueOf(arr);
	}
}
